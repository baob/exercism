object Raindrops {

    fun convert(num : Int) : String {

        val soundResult = sounds.entries.fold("") { acc, sound -> if (num % sound.key == 0) acc + sound.value else acc }

        return if (soundResult.isEmpty()) num.toString() else soundResult
    }

    private val sounds = mapOf(3 to "Pling", 5 to "Plang", 7 to "Plong")
}