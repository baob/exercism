class Matrix(private val matrix: List<List<Int>>) {
    val numRows = matrix.size
    val numCols = matrix[0].size
    val saddlePoints: Set<MatrixCoordinate>

    init { saddlePoints = saddlePoints() }

    private fun saddlePoints(): Set<MatrixCoordinate> =
            allPoints().filter { isSaddlePoint(it) }.toSet()

    private fun allPoints() = if (isEmpty()) listOf() else {
        (0 until numRows * numCols).map { index -> MatrixCoordinate(index % numRows, index / numRows) }
    }

    private fun isSaddlePoint(point: MatrixCoordinate): Boolean {
        val matrixPoint = pointValue(point)
        return  rowValues(point.row).max() == matrixPoint &&
                colValues(point.col).min() == matrixPoint
    }

    private fun isEmpty() = matrix[0].isEmpty()
    private fun pointValue(point: MatrixCoordinate): Int = rowValues(point.row)[point.col]
    private fun colValues(col: Int) = (0 until numRows).map { matrix[it][col] }
    private fun rowValues(row: Int) = matrix[row]
}