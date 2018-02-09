import java.math.BigInteger
import java.math.BigInteger.ONE
import java.math.BigInteger.ZERO

object Board {

    @JvmOverloads
    tailrec fun getGrainCountForSquare(i: Int, ret: BigInteger = ONE): BigInteger {
        require (i in rangeOfSquares) { "Only integers between 1 and 64 (inclusive) are allowed" }
        if (i == 1) return ret
        return getGrainCountForSquare( i - 1, ret + ret )
    }

    fun getTotalGrainCount() = rangeOfSquares.fold(ZERO) { acc, it -> acc + getGrainCountForSquare(it) }

    private val rangeOfSquares = 1..64
}