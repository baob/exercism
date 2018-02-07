class Triangle(val a: Number, val b: Number, val c: Number) {

    private val sides = listOf(a, b, c).map { it.toDouble() }

    init {
        require(listOf(sides[0], sides[1], sides[2]).all { it > 0 })
        require(sides[0] + sides[1] >= sides[2] &&
                sides[2] + sides[0] >= sides[1] &&
                sides[1] + sides[2] >= sides[0]
        )
    }

    val isEquilateral: Boolean = a == b && b == c
    val isIsosceles: Boolean = a == b || b == c || a == c
    val isScalene: Boolean = !isIsosceles
}