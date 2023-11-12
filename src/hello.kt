// maps
val SergalRaceMap = mapOf("northern" to "Northern", "eastern" to "Eastern", "southern" to "Southern", "western" to "Western")

val GenderMap = mapOf("m" to "Male", "f" to "Female", "nb" to "Non-binary")


// classes
class Sergal(var name: String, var race: String, var gender: String) {

}

/* Class instance
issue assignment is nullable so use the not nul operator !! 
could also have used ?: to assign a default if null
*/ 
var Hiroji = Sergal("Hiroji", SergalRaceMap["southern"]!!, GenderMap["m"]!!)

// main function
fun main() {
    println("Merp!")
    mainArrowFunction()
    
    val name = Hiroji.name
    val race = Hiroji.race
    var gender: String 

    when (Hiroji.gender) {
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
}

/* Variable declaration: 
val = read only
var = read write
*/
val user = "Hiroji"

// Arrow function definition with string interpolation
fun mainArrowFunction() = println("Hello, $user.")