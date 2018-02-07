object Isogram {
    fun isIsogram(input: String): Boolean = input
            .toLowerCase()
            .filter{ it.isLetter() }
            .toCharArray()
            .let { it.distinct().size == it.size }
}