object Pangram {
    private val alphabetSize = ('a'..'z').count()

    fun isPangram(pangram: String): Boolean = pangram
            .toLowerCase()
            .toSet()
            .filter(Char::isLetter).size == alphabetSize
}

