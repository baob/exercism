import kotlin.experimental.and

class HandshakeCalculator {

    companion object {

        val mapBinaryPlaceToSignal = Signal.values().map{ Pair(it.ordinal, it) }.toMap()

        fun calculateHandshake(i: Int): List<Signal> {
            val binaryPlaces = intToBinaryPlaceValues(i)
            return mapBinaryPlacesToSignals(binaryPlaces)
        }

        private fun mapBinaryPlacesToSignals(binaryPlaces: List<Int>): List<Signal> {
            val baseList = (0..3).mapNotNull {
                if (binaryPlaces[it] != 0) mapBinaryPlaceToSignal[it] else null
            }
            return if (binaryPlaces[4] != 0) baseList.asReversed() else baseList
        }

        private fun intToBinaryPlaceValues(num: Int): List<Int> {
            return powersOfTwo.mapTo(mutableListOf(), { powerOfTwo -> num and powerOfTwo })
        }

        private val powersOfTwo = listOf(1, 2, 4, 8, 16)
    }

}