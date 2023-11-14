package christmas.model

class MenuOrder(private val menuItem: MenuItem, private val orderedMenuCount: Int) {
    fun getMenuItem() = menuItem
    fun getOrderedMenuCount() = orderedMenuCount
    fun validateOrderMenu(): Boolean {
        return menuItem != MenuItem.NO_MENU
    }

    fun validateMenuCountRange(): Boolean {
        return orderedMenuCount >= MIN_MENU_COUNT
    }

    fun sumMenuCount(totalMenuCount: Int): Int {
        return totalMenuCount + orderedMenuCount
    }

    fun calculateDiscountedAmount(promotion: DiscountPromotion): Int {
        return promotion.applyDiscountToAmount(menuItem.getMenuPrice(), orderedMenuCount)
    }

    fun calculateMenuAmount(): Int {
        return menuItem.getMenuPrice() * orderedMenuCount
    }

    fun validateIsBeverage():Boolean{
        return menuItem.isMenuBeverage()
    }

    companion object {
        private const val MIN_MENU_COUNT = 1
        private const val MAX_MENU_COUNT = 20
    }
}