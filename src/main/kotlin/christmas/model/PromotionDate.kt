package christmas.model

import christmas.util.DataFormatter
import christmas.util.DayOfWeekChecker
import christmas.constants.Constants
import christmas.constants.DayOfWeek
import christmas.exception.IllegalDateException

enum class DiscountPromotion(
    private val promotionDay: List<Int>,
    val discountAmount: Int
) {
    CHRISTMAS_D_DAY_DISCOUNT_PROMOTION((1..25).toList(), 100),
    WEEKDAY_DISCOUNT_PROMOTION(
        listOf(
            DayOfWeek.MONDAY.dayOfWeekNum,
            DayOfWeek.TUESDAY.dayOfWeekNum,
            DayOfWeek.WEDNESDAY.dayOfWeekNum,
            DayOfWeek.THURSDAY.dayOfWeekNum,
            DayOfWeek.SUNDAY.dayOfWeekNum
        ),
        2023
    ),
    WEEKEND_DISCOUNT_PROMOTION(
        (DayOfWeek.FRIDAY.dayOfWeekNum..DayOfWeek.SATURDAY.dayOfWeekNum).toList(),
        2023
    ),
    SPECIAL_DISCOUNT_PROMOTION(listOf(DayOfWeek.SUNDAY.dayOfWeekNum), 1000),
    NO_PROMOTION(listOf(0), 0);

    fun isPromotionDay(date: Int): Boolean {
        return date in promotionDay
    }

    fun calculateChristmasPromotionDiscount(date: Int):Int{
        return 1000 + (CHRISTMAS_D_DAY_DISCOUNT_PROMOTION.discountAmount * (date - 1))
    }
}