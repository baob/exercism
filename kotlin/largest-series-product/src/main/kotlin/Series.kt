class Series(private val number: String) {

    private val numberToInt = number.map{ it.toString().toInt() }

    fun getLargestProduct(length: Int): Int {
        require (length >= 0) { "Length cannot be $length" }

        val startRange = 0..number.length - length
        require (!startRange.isEmpty()) { "product length $length too big for number length ${number.length}" }

        return startRange
                .map { start -> product(start, length) }
                .sorted().last()
    }

    private fun product(start: Int, length: Int) =
            subStringRange(start, length).map { numberToInt[it] }.fold(1) { a, b -> a * b }

    private fun subStringRange(start: Int, length: Int) = (start..endOfRange(start, length))

    private fun endOfRange(start: Int, length: Int) = (start + length - 1)

}