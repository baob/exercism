package Pangram

fun isPangram(pangram : String) :Boolean {
    return (('a'..'z').toList().minus(pangram.toLowerCase().toList())).isEmpty()
}

