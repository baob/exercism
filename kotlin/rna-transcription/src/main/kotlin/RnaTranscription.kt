private val dnaToRnaMap = hashMapOf(
        'C' to "G",
        'G' to "C",
        'T' to "A",
        'A' to "U"
)

fun transcribeToRna(dna: String): String = dna.toCharArray().joinToString("") { singleDnaToRna(it)}

private fun singleDnaToRna(dna: Char): String = dnaToRnaMap[dna] ?: "(no mapping for $dna)"