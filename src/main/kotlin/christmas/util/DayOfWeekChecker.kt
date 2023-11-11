package christmas.util

import java.time.LocalDate

class DayOfWeekChecker {
    fun doDayOfWeek(year: Int = 2023, month: Int = 12, day: Int): Int {
        val date = LocalDate.of(year, month, day)
        val dayOfWeek = date.dayOfWeek
        return dayOfWeek.value
    }
}