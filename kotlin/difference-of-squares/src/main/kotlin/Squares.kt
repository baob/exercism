class Squares(i: Int) {
    private val list = (1..i)

    fun squareOfSum() = list.sum().square()

    fun sumOfSquares() = list.sumBy(Int::square)

    fun difference() = squareOfSum() - sumOfSquares()
}

private fun Int.square() = this * this