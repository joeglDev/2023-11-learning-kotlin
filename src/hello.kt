/* 
Variable declaration: 
val = read only
var = read write
*/
val user = "Hiroji"

// Arrow function definition with string interpolation
fun mainArrowFunction() = println("Hello, $user.")

// maps
val SergalRaceMap = mapOf("northern" to "Northern", "eastern" to "Eastern", "southern" to "Southern", "western" to "Western")

val GenderMap = mapOf("m" to "Male", "f" to "Female", "nb" to "Non-binary")


// classes
open class Sergal(name: String, race: String, gender: String) {
    var Name = name
    var Race = race
    var Gender = gender
}

// inheritance
class Shigu(name: String, race: String, gender: String): Sergal(name, race, gender) {
    val damage = (1..10).random()
    fun attack() {
        println("Halt in the name of the great General Rain!")
        println("The towering Shigu warrior $Name took a swipe at you and did $damage damage.")
    }
}

/*
 Class instance
issue assignment is nullable so use the not nul operator !! 
could also have used ?: to assign a default if null
*/ 
var Hiroji = Sergal("Hiroji", SergalRaceMap["southern"]!!, GenderMap["m"]!!)
var Warrior = Shigu("Syx", SergalRaceMap["northern"]!!, GenderMap["m"]!!);

// main function
fun main() {
    println("Merp!")
    mainArrowFunction()
    
    val name = Hiroji.Name
    val race = Hiroji.Race
    var gender: String 

    when (Hiroji.Gender) {
        "Male" -> gender = GenderMap["m"]!!
        "Female" -> gender = GenderMap["f"]!!
        else -> {
            gender = GenderMap["nb"]!!
        }
    }

    println("*Super smash bros announcer voice")
    println("A new Sergal has appeared.")
    println("Name: $name")
    println("Race: $race")
    println("Gender: $gender")

    println("Oh no you were spotted!")
    Warrior.attack()
}