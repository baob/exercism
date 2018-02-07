object ScrabbleScore {

    fun scoreWord(word : String) = word.fold(0) { acc, letter -> acc + scoreLetter(letter.toString()) }

    private fun scoreLetter(letter : String): Int = mapOfLettersWithScore[letter.toUpperCase()] ?: 0

    private val mapOfLetterListsWithScore = mapOf(
            "A, E, I, O, U, L, N, R, S, T"      to 1,
            "D, G"                              to 2,
            "B, C, M, P"                        to 3,
            "F, H, V, W, Y"                     to 4,
            "K"                                 to 5,
            "J, X"                              to 8,
            "Q, Z"                              to 10
    )

    private val mapOfLettersWithScore : MutableMap<String, Int> = mapOfLetterListsWithScore.entries.fold(mutableMapOf())
        { baseMap , lettersToScore ->
            lettersToScore.key.split(' ', ',').forEach { letter -> baseMap[letter] = lettersToScore.value }
            baseMap
        }

}

