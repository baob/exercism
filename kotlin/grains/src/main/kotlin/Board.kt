import java.math.BigInteger
import java.math.BigInteger.*

object Board {
    private val TWO = BigInteger("2")

    @JvmOverloads
    tailrec fun getGrainCountForSquare(i: Int, ret: BigInteger = ONE): BigInteger {
        require (i in 1..64) { "Only integers between 1 and 64 (inclusive) are allowed" }
        if (i == 1) return ret
        return getGrainCountForSquare( i - 1, TWO * ret )
    }

    fun getTotalGrainCount() = (1..64).fold(ZERO) { acc, it -> acc + getGrainCountForSquare(it) }
}