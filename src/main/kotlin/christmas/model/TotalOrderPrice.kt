package christmas.model

import christmas.validation.exception.IllegalMenuException


class TotalOrderPrice(
    private val orderedMenus: MutableList<MenuOrder>,
    private val discountPromotion: MutableList<DiscountPromotion>
) {
    private var totalOrderPrice: Int = 0

    init {
        getTotalOrderPrice()
        if (isEventAvailable()) {

        }
    }

    private fun isEventAvailable(): Boolean {
        return checkTotalOrderPriceDiscount() && checkBeverageOnlyOrder() && checkMaximumMenuCount()
    }

    private fun checkTotalOrderPriceDiscount(): Boolean {
        return totalOrderPrice >= MINIMUM_TOTAL_ORDER_AMOUNT
    }

    private fun checkBeverageOnlyOrder(): Boolean {
        var beverageMenus = orderedMenus.filter { menuOrder ->
            menuOrder.validateIsBeverage()
        }
        return beverageMenus.size != orderedMenus.size
    }

    private fun checkMaximumMenuCount(): Boolean {
        var totalMenuCount = 0
        orderedMenus.forEach { menuOrder ->
            totalMenuCount = menuOrder.sumMenuCount(totalMenuCount)
        }
        return totalMenuCount <= MAX_TOTAL_MENU_COUNT
    }

    fun getTotalOrderPrice() {
        orderedMenus.forEach { menuOrder ->
            totalOrderPrice += menuOrder.calculateMenuAmount()
        }
    }

    fun getDiscountedTotalOrderPrice() {
        orderedMenus.forEach { menuOrder ->
            totalOrderPrice += menuOrder.calculateMenuAmount()
        }
    }

    private fun applyChristmasDDayDiscount() {

    }

    private fun applySpecialPromotion() {

    }

    companion object {
        private const val MINIMUM_TOTAL_ORDER_AMOUNT = 10000
        private const val MAX_TOTAL_MENU_COUNT = 20

    }
}