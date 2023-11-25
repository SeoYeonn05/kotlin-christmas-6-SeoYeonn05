package christmas.model.promotion

import christmas.model.DiscountPromotion

class SpecialPromotion : Promotion {
    override fun applyPromotion(): Int {
        return DiscountPromotion.SPECIAL_DISCOUNT_PROMOTION.discountAmount
    }
}
