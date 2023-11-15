package christmas.validation

import christmas.model.MenuOrder
import christmas.validation.exception.IllegalMenuException

class MenuInvalidator {
    fun validateMenuItem(reservationMenu: List<MenuOrder>) {
        try {
            checkMenuExistence(reservationMenu)
            checkMenuDuplicates(reservationMenu)
            checkMenuCountRange(reservationMenu)
        } catch (e: Exception) {
            print(e.message)
        }
    }

    private fun checkMenuDuplicates(reservationMenu: List<MenuOrder>) {
        require(reservationMenu.size == reservationMenu.distinct().count()) {
            throw IllegalMenuException.duplicateMenuItem
        }
    }

    private fun checkMenuExistence(reservationMenu: List<MenuOrder>) {
        if (reservationMenu.any { !it.validateOrderMenu() }) {
            throw IllegalMenuException.invalidMenuItem
        }
    }

    private fun checkMenuCountRange(reservationMenu: List<MenuOrder>) {
        val isValid = reservationMenu.all { it.validateMenuCountRange() }
        if (!isValid) {
            throw IllegalMenuException.invalidMenuItem
        }
    }
}