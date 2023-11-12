package christmas.model

import christmas.util.DataFormatter

class MenuManager(private val inputReservationMenu: String) {
    private lateinit var orderedMenu: MutableList<MenuOrder>

    init {
        createOrderedMenu()
    }

    private fun createOrderedMenu() {
        val reservationMenu = inputReservationMenu.split(",")
        reservationMenu.forEach { menuStr: String ->
            orderedMenu.add(convertReservationMenu(menuStr))
        }
    }

    private fun convertReservationMenu(menuStr: String):MenuOrder{
        val splitMenuString = menuStr.split("-")
        val menuName = MenuItem.isMenuAvailable(splitMenuString[0])
        val menuCount = DataFormatter().parseToInt(splitMenuString[1])

        return MenuOrder(menuName ,menuCount)
    }
}