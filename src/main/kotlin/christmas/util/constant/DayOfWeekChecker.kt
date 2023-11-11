package christmas.util.constant

import java.time.LocalDate
import java.util.Calendar

class DayOfWeekChecker {
    fun doDayOfWeek(year: Int = 2023, month: Int = 12, day: Int): Int {
        val date = LocalDate.of(year, month, day)
        val dayOfWeek = date.dayOfWeek
        return dayOfWeek.value
    }
}