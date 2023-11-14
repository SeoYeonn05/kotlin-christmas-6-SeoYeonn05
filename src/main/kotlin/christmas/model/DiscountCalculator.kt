package christmas.model

import christmas.validation.exception.IllegalPromotionException

class DiscountCalculator {
    fun calculateDiscountAmount(
        availablePromotion: DiscountPromotion,
        orderedMenu: MenuOrder
    ): Int {
        return availablePromotion.getDiscountAmount() * orderedMenu.getOrderedMenuCount()
    }
}