import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond(localDateTime : LocalDateTime) {
    private val oneGigaSecond = Duration.ofSeconds(Math.pow(10.0,9.0).toLong())
    val date : LocalDateTime = localDateTime + oneGigaSecond

    constructor(localDate : LocalDate) : this(localDate.atTime(0, 0))
}