class DiamondPrinter {
    fun printToList(char: Char): List<String>? {
        val length = char.toInt() - 'A'.toInt() + 1
        val rows = mutableListOf<String>()

        (0 until length).forEach { line ->
            val baseChars = (0 until length).map { pos -> if (pos == line) ('A'.toInt()+line).toChar() else ' '}
            val rowString = baseChars.reversed().take(length-1).joinToString("") + baseChars.joinToString("")
            rows.add(rowString)
        }

        ((length-2) downTo 0 step 1).forEach { line ->
            rows.add(rows[line])
        }

        return rows
    }
}
