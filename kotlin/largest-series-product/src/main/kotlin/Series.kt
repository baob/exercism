class Series(private val number: String) {

    private val numberToInt = number.map{ it.toString().toInt() }

    fun getLargestProduct(length: Int): Int {
        require (length >= 0) { "Length cannot be $length" }

        val startRange = (0..number.length).takeWhile{ endOfRange(it, length) < number.length }
        require (!startRange.isEmpty()) { "product length $length too big for number length ${number.length}" }

        return startRange
                .map { product(it, length) }
                .sorted().last()
    }

    private fun product(start: Int, length: Int) =
            (start..endOfRange(start, length))
                    .map { numberToInt[it] }
                    .fold(1) { a, b -> a * b }

    private fun endOfRange(start: Int, length: Int) = (start + length - 1)

}