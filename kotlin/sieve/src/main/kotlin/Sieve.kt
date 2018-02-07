object Sieve {


    fun primesUpTo(i: Int): List<Int> {
        val primes = mutableListOf<Int>()
        val sieve = mutableSetOf<Int>()

        (2..i).forEach { candidate ->
            if (candidate !in sieve) {
                primes.add(candidate)
                (2..(i/candidate)).forEach { multiplier -> sieve.add(candidate * multiplier)}
            }
        }
        return primes
    }
}