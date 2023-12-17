import Classes.Sergal
import Classes.Shigu
import Constants.SergalRaceMap
import Constants.GenderMap
import Constants.Gender
import Database.DatabaseOperations

/* 
Variable declaration: 
val = read only
var = read write
*/
val user = "Hiroji"

// Arrow function definition with string interpolation
fun mainArrowFunction() = println("Hello, $user.")

/*
 Class instance
issue assignment is nullable so use the not nul operator !! 
could also have used ?: to assign a default if null
*/ 
var Hiroji = Sergal("Hiroji", SergalRaceMap["southern"]!!, GenderMap["m"]!!)
var Warrior = Shigu("Syx", SergalRaceMap["northern"]!!, GenderMap["m"]!!)

// main function
fun main() {
    println("Merp!")
    mainArrowFunction()
    
    val species = Hiroji.Species
    val name = Hiroji.Name
    val race = Hiroji.Race
    var gender: Gender

    when (Hiroji.Gender) {
        Gender.Male -> gender = GenderMap["m"]!!
        Gender.Female-> gender = GenderMap["f"]!!
        else -> {
            gender = GenderMap["nb"]!!
        }
    }

    println("*Super smash bros announcer voice")
    println("A new Sergal has appeared.")
    println("Species: $species")
    println("Name: $name")
    println("Race: $race")
    println("Gender: $gender")

    println("Oh no you were spotted!")
    Warrior.alertCry()

    attackCycle()
    attackCycle()

    // databases
    databaseStuff()
}

fun attackCycle() {
    println()
    Hiroji.receiveDamage(Warrior.attack())

    Hiroji.getHp()
    Warrior.getHp()
}

fun databaseStuff() {
    val databaseName = "sergals.db"
    val tableName = "characters_table"
    var Db = DatabaseOperations()
    Db.refreshDatabase(databaseName, tableName);
   // Db.connectToDatabase("test.db") 
   Db.insertIntoTable(databaseName, tableName, "Sergal", "Hiroji")
   Db.insertIntoTable(databaseName, tableName, "Sergal", "Syx")
}