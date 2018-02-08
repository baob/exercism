class Squares(i: Int) {
    private val list = (1..i)

    fun squareOfSum() = list.sum().run(::square)

    fun sumOfSquares() = list.sumBy(::square)

    fun difference() = squareOfSum() - sumOfSquares()

    private fun square(it: Int): Int = it * it
}