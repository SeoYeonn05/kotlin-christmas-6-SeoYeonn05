package christmas.model.promotion

import christmas.constants.Constants
import christmas.model.DiscountPromotion
import christmas.model.order.OrderContent
import christmas.util.DayOfWeekChecker

class PromotionApplicator(
    private val orderContent: OrderContent,
    private val totalPrice: Int
) {
    private var promotionResult: MutableMap<DiscountPromotion, Int> = mutableMapOf()
    private val dayOfWeek = DayOfWeekChecker()
    private val date = orderContent.date
    private val orders = orderContent.orders

    init {
        if (isPossiblePromotion(totalPrice)) {
            applyPromotions()
        } else {
            promotionResult[DiscountPromotion.NO_PROMOTION] = 0
        }
    }

    private fun applyPromotions(): MutableMap<DiscountPromotion, Int> {
        if (isChristmasDDayPromotionDate(date)) {
            promotionResult[DiscountPromotion.CHRISTMAS_D_DAY_DISCOUNT_PROMOTION] =
                ChristmasDDayPromotion(date).applyPromotion()
        }
        if (isWeekdayPromotionDate(date)) {
            promotionResult[DiscountPromotion.WEEKDAY_DISCOUNT_PROMOTION] =
                WeekDayPromotion(orders).applyPromotion()
        }
        if (isWeekendPromotionDate(date)) {
            promotionResult[DiscountPromotion.WEEKEND_DISCOUNT_PROMOTION] =
                WeekendDayPromotion(orders).applyPromotion()
        }
        if (isSpecialPromotionDate(date)) {
            promotionResult[DiscountPromotion.SPECIAL_DISCOUNT_PROMOTION] =
                SpecialPromotion().applyPromotion()
        }
        return promotionResult
    }

    fun getPromotionResult() = promotionResult

    private fun isPossiblePromotion(totalPrice: Int): Boolean {
        return checkTotalOrderPriceDiscount(totalPrice)
    }

    private fun checkTotalOrderPriceDiscount(totalPrice: Int): Boolean {
        return totalPrice >= MINIMUM_TOTAL_ORDER_AMOUNT
    }

    private fun isChristmasDDayPromotionDate(date: Int): Boolean {
        return DiscountPromotion.CHRISTMAS_D_DAY_DISCOUNT_PROMOTION.isPromotionDay(date)
    }

    private fun isWeekdayPromotionDate(date: Int): Boolean {
        var dayOfWeek = dayOfWeek.doDayOfWeek(day = date)
        return DiscountPromotion.WEEKDAY_DISCOUNT_PROMOTION.isPromotionDay(dayOfWeek)
    }

    private fun isWeekendPromotionDate(date: Int): Boolean {
        var dayOfWeek = dayOfWeek.doDayOfWeek(day = date)
        return DiscountPromotion.WEEKEND_DISCOUNT_PROMOTION.isPromotionDay(dayOfWeek)
    }

    private fun isSpecialPromotionDate(date: Int): Boolean {
        var dayOfWeek = dayOfWeek.doDayOfWeek(day = date)
        return DiscountPromotion.SPECIAL_DISCOUNT_PROMOTION.isPromotionDay(dayOfWeek) || date == Constants.CHRISTMAS_D_DAY
    }

    companion object {
        const val MINIMUM_TOTAL_ORDER_AMOUNT = 10000
    }
}