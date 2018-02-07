object SumOfMultiples {
    fun sum(multiples: Set<Int>, limit: Int): Int =
        multiples.flatMap { multiple -> setForOneMultiple(limit, multiple) }.toSet().sum()

    private fun setForOneMultiple(limit: Int, multiple: Int): Set<Int> {
        val endOfRange = (limit - 1) / multiple
        return (1..endOfRange).map { it * multiple }.toSet()
    }
}