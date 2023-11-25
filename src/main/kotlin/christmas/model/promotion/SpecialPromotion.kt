package christmas.model.promotion

import christmas.model.DiscountPromotion
import christmas.model.Order
import christmas.model.PromotionApplicator

class SpecialPromotion : Promotion {
    override fun applyPromotion(): Int {
        return DiscountPromotion.SPECIAL_DISCOUNT_PROMOTION.discountAmount
    }
}
