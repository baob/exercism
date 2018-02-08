class HandshakeCalculator {

    companion object {

        private val mapBinaryPlaceToSignal: Map<Int, Signal?> = mapOf(
                1 to Signal.WINK,
                2 to Signal.DOUBLE_BLINK,
                4 to Signal.CLOSE_YOUR_EYES,
                8 to Signal.JUMP,
                16 to null
        )

        fun calculateHandshake(i: Int): List<Signal> {
            val binaryPlaces = intToBinaryPlaceValues(i)
            val baseList = baseSignals(binaryPlaces)
            return reverseIfNeeded(binaryPlaces, baseList)
        }

        private fun baseSignals(binaryPlaces: List<Int>) =
                binaryPlaces.mapNotNull { if (it != 0) mapBinaryPlaceToSignal[it] else null }

        private fun reverseIfNeeded(binaryPlaces: List<Int>, baseList: List<Signal>) =
                if (binaryPlaces.last() != 0) baseList.asReversed() else baseList

        private fun intToBinaryPlaceValues(num: Int): List<Int> {
            return mapBinaryPlaceToSignal.keys.mapTo(mutableListOf(), { powerOfTwo -> num and powerOfTwo })
        }

    }

}