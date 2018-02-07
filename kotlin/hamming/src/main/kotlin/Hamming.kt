object Hamming {

    fun compute(dna1: String, dna2: String): Int {
        require (dna1.length == dna2.length) { "left and right strands must be of equal length." }

        return dna1.filterIndexed{index, singleDna1 -> dna2[index] != singleDna1}.length
    }
}

