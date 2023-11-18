package Classes


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