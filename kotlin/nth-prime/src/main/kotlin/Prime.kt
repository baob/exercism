object Prime {
    fun nth(number: Int): Int {
        require( number > 0 ) { "There is no zeroth prime." }
        return nthListOfPrimes(number, listOf(), 2).last()
    }

    private tailrec fun nthListOfPrimes(number: Int, primes: List<Int>, possible: Int): List<Int> {
        if ( primes.size == number ) return primes
        return nthListOfPrimes(number, newPrimesList(possible, primes), possible + 1)
    }

    private fun newPrimesList(possible: Int, primes: List<Int>) =
            if (isNextPrime(possible, primes)) primes.plus(possible) else primes

    private fun isNextPrime(possible: Int, primes: List<Int>) =
            selectDivisors(possible, primes).all { possible % it != 0 }

    private fun selectDivisors(possible: Int, primes: List<Int>) =
            primes.takeWhile { it*it <= possible }
}