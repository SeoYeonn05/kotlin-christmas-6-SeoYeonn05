package christmas.model

import christmas.constants.MenuCategory
import christmas.constants.MenuItem

class Order(private val menu: MenuItem, private val count: Int) {
    fun getMenu() = menu
    fun getCount() = count
    fun validateOrderMenu(): Boolean {
        return menu != MenuItem.NO_MENU
    }

    fun checkBeverage(): Boolean {
        return menu.category == MenuCategory.BEVERAGE
    }

    fun calculateMenuAmount(): Int {
        return menu.price * count
    }
}