import java.lang.Character.isWhitespace

class Luhn {
    companion object {

        fun isValid(numberUnSanitized: String): Boolean {
            val number = numberUnSanitized.filterNot(::isWhitespace)

            if ( number.length <= 1 ) return false
            if ( number.any{ it !in '0'..'9' } ) return false

            return number
                    .reversed()
                    .mapIndexed{ index, digit -> digit.luhnComponent(index) }
                    .sum()
                    .rem(10) == 0
        }
    }
}

private val Int.isEven: Boolean get() = this % 2 == 0

private val Int.luhnComponentIfOdd get() = if (2 * this > 9) 2 * this - 9 else 2 * this

private val Char.digitToInt get() = toString().toInt()

private fun Char.luhnComponent(index: Int) =
        if (index.isEven) digitToInt
        else              digitToInt.luhnComponentIfOdd


