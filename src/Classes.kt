package Classes


// classes
open class Sergal(name: String, race: String, gender: String) {
    var Name = name
    var Race = race
    var Gender = gender
    open val BaseHp = 10
    open var CurrentHp: Int = BaseHp
    var IsActive = true

    fun getHp(): Int {
        println("$Name's remaining HP is $CurrentHp.")
        return CurrentHp
    }

    fun receiveDamage(damageValue: Int) {
        println("$Name received $damageValue damage.")
        CurrentHp = CurrentHp - damageValue

        if (CurrentHp <= 0) {
            println("$Name: Fuck I'm injured I'm outta here")
            println("$Name left the battle to recover.")
            IsActive = false
    }
}
}

// inheritance
class Shigu(name: String, race: String, gender: String): Sergal(name, race, gender) {
    override val BaseHp = 100
    override var CurrentHp = BaseHp

    fun alertCry() {
        println("Halt in the name of the great General Rain!")
    }

    fun attack(): Int {
        val damage = (1..10).random()

        println("The towering Shigu warrior $Name took a swipe at you and did $damage damage.")
        return damage
    }
}