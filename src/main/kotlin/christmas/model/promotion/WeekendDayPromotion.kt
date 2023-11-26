package christmas.model.promotion

import christmas.constants.MenuCategory
import christmas.model.DiscountPromotion
import christmas.model.order.Order

class WeekendDayPromotion(private val orders: MutableList<Order>) : Promotion {

    override fun applyPromotion(): Int {
        var discountAmount = 0
        var validCategoryMenu = orders.filter { order ->
            order.getMenu().category == weekendPromotionApplyMenu
        }
        validCategoryMenu.forEach {
            discountAmount =
                DiscountPromotion.WEEKEND_DISCOUNT_PROMOTION.discountAmount * it.getCount()
        }
        return discountAmount
    }

    companion object {
        val weekendPromotionApplyMenu = MenuCategory.MAIN
    }
}
