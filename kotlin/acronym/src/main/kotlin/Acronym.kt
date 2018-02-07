package Acronym

fun generate(fullName : String) : String {
    return acronymiseWords(fullName.split(' ', '-'))
}

private fun acronymiseWords(words: List<String>): String {
    return words.joinToString("") { it.first().toString() }.toUpperCase()
}