package christmas.model

import christmas.util.DataFormatter
import christmas.validation.exception.IllegalMenuException

class MenuManager(private val inputReservationMenu: String) {
    private lateinit var orderedMenu: MutableList<MenuOrder>

    init {
        createOrderedMenu()
        // 예외처리를 모델에서 할까? 컨트롤러에 불러와서 할까?
        //MenuInvalidator(orderedMenu)
        validateTotalMenuCount()
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

    private fun validateTotalMenuCount() {
        var totalMenuCount = 0
        orderedMenu.forEach { menuOrder ->
            totalMenuCount = menuOrder.sumMenuCount(totalMenuCount)
        }
        if (totalMenuCount > MAX_TOTAL_MENU_COUNT) {
            IllegalMenuException.invalidMenuCount
        }
    }

    fun sumMenuAmount(): Int {
        var totalMenuAmount: Int = 0

        orderedMenu.forEach { menuOrder ->
            totalMenuAmount += menuOrder.calculateMenuAmount()
        }
        return totalMenuAmount
    }

    companion object {
        private const val MAX_TOTAL_MENU_COUNT = 20
    }
}