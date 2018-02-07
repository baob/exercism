class SpaceAge(private val ageInSeconds: Double) {

    private val earthOrbitInSeconds = 31557600.0

    fun onEarth() = ratioToTwoPlaces(earthOrbitInSeconds)

    fun onMercury() = ratioToTwoPlaces( 0.2408467 * earthOrbitInSeconds)
    fun onVenus() = ratioToTwoPlaces( 0.61519726 * earthOrbitInSeconds)
    fun onMars() = ratioToTwoPlaces( 1.8808158 * earthOrbitInSeconds)
    fun onJupiter() = ratioToTwoPlaces( 11.862615 * earthOrbitInSeconds)
    fun onSaturn() = ratioToTwoPlaces( 29.447498 * earthOrbitInSeconds)
    fun onUranus() = ratioToTwoPlaces( 84.016846 * earthOrbitInSeconds)
    fun onNeptune() = ratioToTwoPlaces( 164.79132 * earthOrbitInSeconds)

    private fun ratioToTwoPlaces(orbitInSeconds: Double): Double {
        return Math.round(ageInSeconds * 100 / orbitInSeconds).toDouble() / 100.0
    }

    constructor(ageInSeconds: Number) : this(ageInSeconds.toDouble())
}