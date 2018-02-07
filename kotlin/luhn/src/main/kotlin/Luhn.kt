class Luhn {
    companion object {
        private val nineToInt = '9'.toInt()
        private val zeroToInt = '0'.toInt()

        fun isValid(numberUnSanitized: String): Boolean {
            val number = numberUnSanitized.filter { it != ' ' }

            if (number.length <= 1) return false
            if (!number.all{ (zeroToInt..nineToInt).contains(it.toInt()) }) return false

            val checksum = number.reversed().foldIndexed(0) { index: Int, accumulator: Int, digit: Char ->
                val digitAsInt = digit.toString().toInt()
                val digitDoubled = 2 * digitAsInt
                val component: Int = when (index.isEven()) {
                    true -> digitAsInt
                    else -> if ( digitDoubled > 9 ) digitDoubled - 9 else digitDoubled }
                accumulator + component
            }
            return checksum % 10 == 0
        }
    }
}

private fun Int.isEven(): Boolean = (this.rem(2) == 0)
