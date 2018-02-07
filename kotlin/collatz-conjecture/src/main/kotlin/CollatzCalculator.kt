import java.math.BigInteger
import java.math.BigInteger.ONE
import java.math.BigInteger.ZERO

object CollatzCalculator {
    fun computeStepCount(i: Int, steps: Int = 0): Int {
        require( i > 0 ) { "Only natural numbers are allowed" }
        return rawComputeStepCount(BigInteger(i.toString()), steps)
    }

    private val TWO = ONE + ONE
    private val THREE = TWO + ONE

    private tailrec fun rawComputeStepCount(i: BigInteger, steps: Int = 0): Int {
        if (i == ONE) return steps

        val next = when {
            i % TWO == ZERO -> i / TWO
            else            -> THREE * i + ONE
        }

        return rawComputeStepCount(next, steps + 1)
    }
}