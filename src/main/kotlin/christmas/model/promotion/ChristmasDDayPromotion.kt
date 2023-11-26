package christmas.model.promotion

import christmas.model.DiscountPromotion

class ChristmasDDayPromotion(private val date: Int) : Promotion {
    override fun applyPromotion(): Int {
        return DiscountPromotion.CHRISTMAS_D_DAY_DISCOUNT_PROMOTION.calculateChristmasPromotionDiscount(date)
    }
}