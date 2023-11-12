package christmas.validation

import christmas.model.MenuOrder
import christmas.validation.exception.IllegalMenuException

class MenuInvalidator(reservationMenu: List<MenuOrder>) {
    init {
        validateMenuItem(reservationMenu)
    }

    private fun validateMenuItem(reservationMenu: List<MenuOrder>) {
        checkMenuExistence(reservationMenu)
        checkMenuDuplicates(reservationMenu)
        checkMenuCountRange(reservationMenu)
    }

    private fun checkMenuDuplicates(reservationMenu: List<MenuOrder>) {
        require(reservationMenu.size == reservationMenu.distinct().count()) {
            IllegalMenuException.duplicateMenuItem
        }
    }

    private fun checkMenuExistence(reservationMenu: List<MenuOrder>) {
        require(return reservationMenu.forEach {
            it.validateOrderMenu()
        }) { IllegalMenuException.invalidMenuItem }
    }

    private fun checkMenuCountRange(reservationMenu: List<MenuOrder>) {
        require(return reservationMenu.forEach {
            it.validateMenuCountRange()
        }) { IllegalMenuException.invalidMenuCount }
    }
}