package christmas.model

import christmas.util.DataFormatter
import christmas.validation.MenuInvalidator
import christmas.validation.exception.IllegalMenuException
import kotlin.io.path.createTempDirectory

class MenuManager(private val inputReservationMenu: String) {
    private var orderedMenu: MutableList<MenuOrder> = mutableListOf()

    init {
        createOrderedMenu()
        MenuInvalidator().validateMenuItem(orderedMenu)
    }

    fun getOrderedMenu() = orderedMenu

    private fun createOrderedMenu() {
        val reservationMenu = inputReservationMenu.split(",")
        reservationMenu.forEach { menuStr: String ->
            orderedMenu.add(convertReservationMenu(menuStr))
        }
    }

    private fun convertReservationMenu(menuStr: String): MenuOrder {
        val splitMenuString = menuStr.split("-")
        val menuName = MenuItem.isMenuAvailable(splitMenuString[0])
        val menuCount = DataFormatter().parseToIntMenuCount(splitMenuString[1])

        return MenuOrder(menuName, menuCount)
    }
}