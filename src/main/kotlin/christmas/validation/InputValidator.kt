package christmas.validation

import christmas.util.DataFormatter
import christmas.validation.exception.IllegalDateException
import christmas.validation.exception.IllegalMenuException

class InputValidator {
    fun validateInputReservationDate(inputReservationDate: String): Boolean {
        val reservationDate = convertReservationDate(inputReservationDate)

        return try {
            isReservationDatePositive(reservationDate)
            true
        } catch (e: IllegalMenuException) {
            false
        }
    }

    fun validateInputReservationMenu(inputReservationMenu: String) {
        var reservationMenu = inputReservationMenu.split(",")
        reservationMenu.forEach { validateMenuOrder(it) }
    }
    private fun validateMenuOrder(reservationMenu: String) {
        val regex = Regex("^[가-힣A-Za-z]+-\\d+\$")
        if (!reservationMenu.matches(regex)) {
            throw IllegalMenuException.invalidMenuFormat
        }
    }

    private fun convertReservationDate(input: String): Int {
        return DataFormatter().parseToIntDate(input)
    }

    private fun isReservationDatePositive(input: Int) {
        require(input > 0) { throw IllegalDateException.invalidNumericValue }
    }
}