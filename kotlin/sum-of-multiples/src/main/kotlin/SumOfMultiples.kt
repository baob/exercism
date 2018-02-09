object SumOfMultiples {
    fun sum(multiples: Set<Int>, limit: Int): Int =
            multiples
                    .flatMap { listForOneMultiple(limit, it) }
                    .distinct()
                    .sum()

    private fun listForOneMultiple(limit: Int, multiple: Int) =
            (multiple until limit step multiple)
}