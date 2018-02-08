class HandshakeCalculator {

    companion object {

        private val mapBinaryPlaceToSignal: Map<Int, Signal> = mapOf(
                0 to Signal.WINK,
                1 to Signal.DOUBLE_BLINK,
                2 to Signal.CLOSE_YOUR_EYES,
                3 to Signal.JUMP
        )

        fun calculateHandshake(i: Int): List<Signal> {
            val binList = intToBinList(i)
            return mapBinaryPlacesToSignals(binList)
        }

        private fun mapBinaryPlacesToSignals(binList: List<Int>): List<Signal> {
            val baseList = (0..3).mapNotNull { if (binList[it] == 1) mapBinaryPlaceToSignal[it] else null }
            if (binList[4] == 1) return baseList.asReversed()
            else                 return baseList
        }


        private fun intToBinList(num: Int): List<Int> {
            var ret = mutableListOf<Int>()
            var workingNum = num
            return (1..5).toList().mapTo(ret, { _: Int -> val r = (workingNum % 2); workingNum /= 2; r })
        }

    }

}