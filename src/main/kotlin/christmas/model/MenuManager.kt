package christmas.model

import christmas.util.DataFormatter
import christmas.validation.MenuInvalidator
import christmas.validation.exception.IllegalMenuException

class MenuManager(private val inputReservationMenu: String) {
    private var orderedMenus: MutableList<MenuOrder> = mutableListOf()

    init {
        createOrderedMenu()
        MenuInvalidator().validateMenuItem(orderedMenus)
        checkOrderMenuConditions()
    }

    fun getOrderedMenu() = orderedMenus

    private fun checkOrderMenuConditions() {
        checkBeverageOnlyOrder()
        checkMaximumMenuCount()
    }

    private fun checkBeverageOnlyOrder() {
        var beverageMenus = orderedMenus.filter { menuOrder ->
            menuOrder.validateIsBeverage()
        }
        if (beverageMenus.size == orderedMenus.size) {
            throw IllegalMenuException.onlyBeverageOrder
        }
    }

    private fun checkMaximumMenuCount() {
        var totalMenuCount = 0
        orderedMenus.forEach { menuOrder ->
            totalMenuCount = menuOrder.sumMenuCount(totalMenuCount)
        }
        if (totalMenuCount > MAX_TOTAL_MENU_COUNT) {
            throw IllegalMenuException.maximumOrderCount
        }
    }

    private fun createOrderedMenu() {
        val reservationMenu = inputReservationMenu.split(",")
        reservationMenu.forEach { menuStr: String ->
            orderedMenus.add(convertReservationMenu(menuStr))
        }
    }

    private fun convertReservationMenu(menuStr: String): MenuOrder {
        val splitMenuString = menuStr.split("-")
        val menuName = MenuItem.isMenuAvailable(splitMenuString[0])
        var menuCount: Int = 0
        try {
            menuCount = DataFormatter().parseToIntMenuCount(splitMenuString[1])
        } catch (e: IllegalMenuException) {
            println(e.message)
        }
        return MenuOrder(menuName, menuCount)
    }

    companion object {
        private const val MAX_TOTAL_MENU_COUNT = 20
    }
}