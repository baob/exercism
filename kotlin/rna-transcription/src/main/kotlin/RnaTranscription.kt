private val dnaToRnaMap = hashMapOf(
        "C" to "G",
        "G" to "C",
        "T" to "A",
        "A" to "U"
)

fun transcribeToRna(dna: String): String = dna.map{ transcribeSingleDnaToRna(it.toString())}.joinToString("")

private fun transcribeSingleDnaToRna(dna: String): String = dnaToRnaMap[dna] ?: "(no mapping for $dna)"