package christmas.util

import christmas.util.constant.Constants
import java.time.LocalDate

class DayOfWeekChecker {
    fun doDayOfWeek(year: Int = Constants.PROMOTION_YEAR, month: Int = Constants.PROMOTION_MONTH, day: Int): Int {
        val date = LocalDate.of(year, month, day)
        val dayOfWeek = date.dayOfWeek
        return dayOfWeek.value
    }
}