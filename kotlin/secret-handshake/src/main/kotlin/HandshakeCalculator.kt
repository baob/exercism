class HandshakeCalculator {

    companion object {

        private val mapBinaryPlaceToSignal = mapOf(
                0 to Signal.WINK,
                1 to Signal.DOUBLE_BLINK,
                2 to Signal.CLOSE_YOUR_EYES,
                3 to Signal.JUMP
        )

        fun calculateHandshake(i: Int): List<Signal> {
            val binDigits = intToBinDigitValues(i)
            return mapBinaryPlacesToSignals(binDigits)
        }

        private fun mapBinaryPlacesToSignals(binDigits: List<Int>): List<Signal> {
            val baseList = (0..3).mapNotNull { if (binDigits[it] != 0) mapBinaryPlaceToSignal[it] else null }
            if (binDigits[4] != 0) return baseList.asReversed()
            else                   return baseList
        }

        private fun intToBinDigitValues(num: Int): List<Int> {
            return listOf(1,2,4,8,16).mapTo(mutableListOf(), { powerOfTwo -> num and powerOfTwo })
        }

    }

}