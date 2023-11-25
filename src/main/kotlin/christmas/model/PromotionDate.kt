package christmas.model

import christmas.util.DataFormatter
import christmas.util.DayOfWeekChecker
import christmas.constants.Constants
import christmas.exception.IllegalDateException

enum class DayOfWeekType(val dayOfWeekNum: Int) {
    MONDAY(dayOfWeekNum = 1),
    TUESDAY(dayOfWeekNum = 2),
    WEDNESDAY(dayOfWeekNum = 3),
    THURSDAY(dayOfWeekNum = 4),
    FRIDAY(dayOfWeekNum = 5),
    SATURDAY(dayOfWeekNum = 6),
    SUNDAY(dayOfWeekNum = 7);

    companion object {
        fun getWeekdaysExceptFridayAndSaturday(): List<Int> {
            return values()
                .filter { it != FRIDAY && it != SATURDAY }
                .map { it.dayOfWeekNum }
        }
    }
}

enum class DiscountPromotion(
    private val promotionRange: List<Int>,
    private val discountAmount: Int
) {
    CHRISTMAS_D_DAY_DISCOUNT_PROMOTION((1..25).toList(), 100),
    WEEKDAY_DISCOUNT_PROMOTION(
        DayOfWeekType.getWeekdaysExceptFridayAndSaturday(),
        2023
    ),
    WEEKEND_DISCOUNT_PROMOTION(
        (DayOfWeekType.FRIDAY.dayOfWeekNum..DayOfWeekType.SATURDAY.dayOfWeekNum).toList(),
        2023
    ),
    SPECIAL_DISCOUNT_PROMOTION(listOf(DayOfWeekType.SUNDAY.dayOfWeekNum), 1000),
    NO_PROMOTION(listOf(0), 0);

    fun getDiscountAmount() = this.discountAmount
    fun checkPromotionRange(date: Int): Boolean {
        return date in promotionRange
    }
}

class PromotionDate(private val inputReservationDate: String) {
    private var availablePromotions: MutableList<DiscountPromotion> = mutableListOf()
    private val reservationDate: Int
    private val dayOfWeek = DayOfWeekChecker()

    init {
        this.reservationDate = convertReservationDate()
        checkPromotionDate()
    }

    fun getReservationDate() = reservationDate
    fun getAvailablePromotions() = availablePromotions


    private fun convertReservationDate(): Int {
        try {
            return DataFormatter().parseToIntDate(inputReservationDate)
        } catch (e: IllegalDateException) {
            println(e.message)
            throw e
        }
    }

    private fun checkPromotionDate() {
        if (isChristmasDDayPromotionDate(reservationDate)) {
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
        return DiscountPromotion.CHRISTMAS_D_DAY_DISCOUNT_PROMOTION.checkPromotionRange(date)
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
        return DiscountPromotion.SPECIAL_DISCOUNT_PROMOTION.checkPromotionRange(dayOfWeek) || date == Constants.CHRISTMAS_D_DAY
    }
}
