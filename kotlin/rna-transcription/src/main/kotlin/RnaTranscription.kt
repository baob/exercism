fun transcribeToRna(dna: String): String =
        dna.map { dnaToRnaMap[it] ?: "(no mapping for $it)" }.joinToString("")

private val dnaToRnaMap = hashMapOf(
        'C' to "G",
        'G' to "C",
        'T' to "A",
        'A' to "U"
)