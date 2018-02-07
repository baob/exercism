
object Atbash {
    fun decode(input: String): String {
        return input
                .toLowerCase()
                .map { char ->  lookup[char] ?: char}
                .filter{it !in listOf(' ')}
                .joinToString("")
    }

    fun encode(input: String): String {
        return input
                .toLowerCase()
                .map { char ->  lookup[char] ?: char}
                .filter{it !in listOf(' ', ',', '.')}
                .chunked(5) { it.joinToString("")}
                .joinToString(" ")
    }

    private val alphabet = 'a'..'z'
    private val lookup = (alphabet zip (alphabet.reversed() )).toMap()
}