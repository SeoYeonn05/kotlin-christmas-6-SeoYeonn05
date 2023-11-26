package christmas.model.promotion

import christmas.constants.MenuCategory
import christmas.model.DiscountPromotion
import christmas.model.order.Order

class WeekDayPromotion(private val orders: MutableList<Order>) : Promotion {
    override fun applyPromotion(): Int {
        var discountAmount = 0
        var filterApplyMenu = orders.filter { order ->
            order.getMenu().category == weekdayPromotionApplyMenu
        }
        filterApplyMenu.forEach {
            discountAmount =
                DiscountPromotion.WEEKDAY_DISCOUNT_PROMOTION.discountAmount * it.getCount()
        }
        return discountAmount
    }

    companion object {
        val weekdayPromotionApplyMenu = MenuCategory.DESSERT
    }
}