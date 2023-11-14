package christmas.model

import christmas.util.DataFormatter
import christmas.validation.exception.IllegalMenuException

class MenuManager(private val inputReservationMenu: String) {
    private lateinit var orderedMenu: MutableList<MenuOrder>

    init {
        createOrderedMenu()
        // 예외처리를 모델에서 할까? 컨트롤러에 불러와서 할까?
        //MenuInvalidator(orderedMenu)
    }

    private fun createOrderedMenu() {
        val reservationMenu = inputReservationMenu.split(",")
        reservationMenu.forEach { menuStr: String ->
            orderedMenu.add(convertReservationMenu(menuStr))
        }
    }

    private fun convertReservationMenu(menuStr: String): MenuOrder {
        val splitMenuString = menuStr.split("-")
        val menuName = MenuItem.isMenuAvailable(splitMenuString[0])
        val menuCount = DataFormatter().parseToInt(splitMenuString[1])

        return MenuOrder(menuName, menuCount)
    }

    fun sumMenuAmount(): Int {
        var totalMenuAmount: Int = 0

        orderedMenu.forEach { menuOrder ->
            totalMenuAmount += menuOrder.calculateMenuAmount()
        }
        return totalMenuAmount
    }
}