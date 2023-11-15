package christmas.model

import christmas.validation.exception.IllegalPromotionException

class DiscountCalculator {
    fun calculateDiscountAmount(
        availablePromotion: DiscountPromotion,
        orderedMenu: MenuOrder
    ): Int {
        if (availablePromotion == DiscountPromotion.WEEKDAY_DISCOUNT_PROMOTION || availablePromotion == DiscountPromotion.WEEKEND_DISCOUNT_PROMOTION) {
            return availablePromotion.getDiscountAmount() * orderedMenu.getOrderedMenuCount()
        } else {
            throw IllegalPromotionException.invalidPromotion
        }
    }
}