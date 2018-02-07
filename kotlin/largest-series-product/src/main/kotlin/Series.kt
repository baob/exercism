class Series(private val number: String) {

    private val numberToInt = number.map{ it.toString().toInt() }

    fun getLargestProduct(length: Int): Int {
        if (length < 0) throw IllegalArgumentException("Length cannot be $length")

        val startRange = 0..number.length - length
        if (startRange.isEmpty()) throw IllegalArgumentException("product length $length too big for number length ${number.length}")

        return startRange.map { start -> product(start, length) }.sorted().last()
    }

    private fun product(start: Int, length: Int) =
            (start..(start + length - 1)).map { numberToInt[it] }.fold(1) { a, b -> a * b }

}