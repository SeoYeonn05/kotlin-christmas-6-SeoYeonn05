package christmas.model

import christmas.validation.exception.IllegalPromotionException

class DiscountCalculator(
    private val availablePromotion: DiscountPromotion,
    private val orderedMenu: MenuOrder?
) {
    init {
        when (availablePromotion) {
            DiscountPromotion.CHRISTMAS_D_DAY_DISCOUNT_PROMOTION -> {}
            DiscountPromotion.WEEKDAY_DISCOUNT_PROMOTION -> applyWeekDayPromotion()
            DiscountPromotion.WEEKEND_DISCOUNT_PROMOTION -> applyWeekendPromotion()
            DiscountPromotion.SPECIAL_DISCOUNT_PROMOTION -> {}
            else -> IllegalPromotionException.invalidPromotion
        }
    }
    private fun applyWeekDayPromotion() {
        orderedMenu?.calculateDiscountedAmount(availablePromotion)
    }
    private fun applyWeekendPromotion() {
        orderedMenu?.calculateDiscountedAmount(availablePromotion)
    }
}