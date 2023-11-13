package christmas.model

import christmas.util.DataFormatter
import christmas.util.DayOfWeekChecker

enum class DayOfWeekType(val dayOfWeekNum: Int) {
    SUNDAY(dayOfWeekNum = 1),
    MONDAY(dayOfWeekNum = 2),
    TUESDAY(dayOfWeekNum = 3),
    WEDNESDAY(dayOfWeekNum = 4),
    THURSDAY(dayOfWeekNum = 5),
    FRIDAY(dayOfWeekNum = 6),
    SATURDAY(dayOfWeekNum = 7),
}

enum class DiscountPromotion(private val promotionRange: List<Int>) {
    CHRISTMAS_D_DAY_DISCOUNT_PROMOTION((1..25).toList()),
    WEEKDAY_DISCOUNT_PROMOTION((DayOfWeekType.SUNDAY.dayOfWeekNum..DayOfWeekType.THURSDAY.dayOfWeekNum).toList()),
    WEEKEND_DISCOUNT_PROMOTION((DayOfWeekType.FRIDAY.dayOfWeekNum..DayOfWeekType.SATURDAY.dayOfWeekNum).toList()),
    SPECIAL_DISCOUNT_PROMOTION(listOf(DayOfWeekType.SUNDAY.dayOfWeekNum, 25)),
    NO_PROMOTION(listOf(0));

    fun checkPromotionRange(date: Int): Boolean {
        return date in promotionRange
    }
}

class PromotionDate(private val inputReservationDate: String) {
    private lateinit var availablePromotions: MutableList<DiscountPromotion>
    private val reservationDate: Int
    private val dayOfWeek = DayOfWeekChecker()

    init {
        this.reservationDate = convertReservationDate()
        checkPromotionDate()
    }

    fun getAvailablePromotions(): MutableList<DiscountPromotion> {
        return availablePromotions
    }

    private fun convertReservationDate(): Int {
        return DataFormatter().parseToInt(inputReservationDate)
    }

    private fun checkPromotionDate() {
        if (isChristmasDDayPromotionDate(reservationDate)){
            availablePromotions.add(DiscountPromotion.CHRISTMAS_D_DAY_DISCOUNT_PROMOTION)
        }
        if (isWeekdayPromotionDate(reservationDate)) {
            availablePromotions.add(DiscountPromotion.WEEKDAY_DISCOUNT_PROMOTION)
        }

        if (isWeekendPromotionDate(reservationDate)) {
            availablePromotions.add(DiscountPromotion.WEEKEND_DISCOUNT_PROMOTION)
        }

        if (isSpecialPromotionDate(reservationDate)) {
            availablePromotions.add(DiscountPromotion.SPECIAL_DISCOUNT_PROMOTION)
        }
    }

    private fun isChristmasDDayPromotionDate(date: Int): Boolean {
        var dayOfWeek = dayOfWeek.doDayOfWeek(day = date)
        return DiscountPromotion.CHRISTMAS_D_DAY_DISCOUNT_PROMOTION.checkPromotionRange(dayOfWeek)
    }

    private fun isWeekdayPromotionDate(date: Int): Boolean {
        var dayOfWeek = dayOfWeek.doDayOfWeek(day = date)
        return DiscountPromotion.WEEKDAY_DISCOUNT_PROMOTION.checkPromotionRange(dayOfWeek)
    }

    private fun isWeekendPromotionDate(date: Int): Boolean {
        var dayOfWeek = dayOfWeek.doDayOfWeek(day = date)
        return DiscountPromotion.WEEKEND_DISCOUNT_PROMOTION.checkPromotionRange(dayOfWeek)
    }

    private fun isSpecialPromotionDate(date: Int): Boolean {
        var dayOfWeek = dayOfWeek.doDayOfWeek(day = date)
        return DiscountPromotion.SPECIAL_DISCOUNT_PROMOTION.checkPromotionRange(dayOfWeek)
    }
}
