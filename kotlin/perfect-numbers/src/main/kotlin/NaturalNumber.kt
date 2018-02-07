enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    val divisors = properDivisorsOf(naturalNumber)

    if (divisors.sum() == naturalNumber) return Classification.PERFECT
    if (divisors.sum() >= naturalNumber) return Classification.ABUNDANT
    return Classification.DEFICIENT
}

private fun properDivisorsOf(naturalNumber: Int): MutableSet<Int> {
    if (naturalNumber < 1) throw RuntimeException("$naturalNumber is not a natural number")

    val possibles = divisorPossibles(naturalNumber)
    val divisors = mutableSetOf<Int>()

    possibles.forEach { possible ->
        if (naturalNumber % possible == 0) {
            divisors.add(possible)
            if (possible != 1) divisors.add(naturalNumber / possible)
        }
    }
    return divisors
}

private fun divisorPossibles(naturalNumber: Int): Set<Int> {
    val rootNatural = Math.sqrt(naturalNumber.toDouble()).toInt()
    val endOfRange = listOf(rootNatural, naturalNumber - 1).min()
    return (1..endOfRange!!).toSet()
}

