package Constants

// enums
enum class Gender {
    Male, Female, NonBinary
}

enum class SergalRace {
Northern, Southern, Eastern, Western
}

enum class EltusSpecies {
    Sergal, Nevrean, Agudner
}

// maps
val SergalRaceMap = mapOf("northern" to SergalRace.Northern, "eastern" to SergalRace.Eastern, "southern" to SergalRace.Southern, "western" to SergalRace.Western)

val GenderMap = mapOf("m" to Gender.Male, "f" to Gender.Female, "nb" to Gender.NonBinary)