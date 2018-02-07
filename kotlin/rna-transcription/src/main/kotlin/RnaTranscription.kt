fun transcribeToRna(dna: String): String                                                                                                                                                                                                                                                                        {
    return dna.toCharArray().joinToString("") { dnaToRnaMap[it] ?: "(no mapping for $it)" }
}

private val dnaToRnaMap = hashMapOf(
        'C' to "G",
        'G' to "C",
        'T' to "A",
        'A' to "U"
)