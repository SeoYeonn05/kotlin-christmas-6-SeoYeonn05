package christmas.model

import christmas.constants.MenuCategory
import christmas.constants.MenuItem

class Order(private val menu: MenuItem, private val count: Int) {
    fun getMenuItem() = menu
    fun getOrderedMenuCount() = count
    fun validateOrderMenu(): Boolean {
        return menu != MenuItem.NO_MENU
    }

    fun sumMenuCount(totalMenuCount: Int): Int {
        return totalMenuCount + count
    }

    fun calculateMenuAmount(): Int {
        return menu.price * count
    }

    fun checkBeverage(): Boolean {
        return menu.category == MenuCategory.BEVERAGE
    }
}