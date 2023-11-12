package christmas.view

import christmas.util.InputHandler
import christmas.validation.InputValidator
import christmas.validation.exception.IllegalDateException
import christmas.validation.exception.IllegalMenuException

class InputProcessor {
    fun requestReservationDate(): String {
        var input: String = InputHandler().inputHandler { input ->
            val isValid = InputValidator().validateInputReservationDate(input)
            if (!isValid) {
                IllegalDateException.invalidNumericValue
            }
            isValid
        }
        return input
    }

    fun requestReservationMenu(): String {
        var input: String = InputHandler().inputHandler { input ->
            val isValid = InputValidator().validateInputReservationMenu(input)
            if (!isValid) {
                IllegalMenuException.invalidMenuFormat
            }
            isValid
        }
        return input
    }
}