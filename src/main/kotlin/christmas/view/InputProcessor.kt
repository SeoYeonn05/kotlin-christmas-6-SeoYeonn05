package christmas.view

import christmas.util.InputHandler
import christmas.util.constant.Constants
import christmas.validation.InputValidator

class InputProcessor {
    fun requestReservationDate(): String {
        lateinit var input: String
        var validInput: Boolean = false


        while (!validInput) {
            input = InputHandler().inputHandler()
            validInput = InputValidator().validateInputReservationDate(input)
            println(input)
        }
        return input
    }

    fun requestReservationMenu(): String {
        lateinit var input: String
        var validInput: Boolean = false
        print(Constants.REQUEST_RESERVATION_DATE)

        while (!validInput) {
            input = InputHandler().inputHandler()
            validInput = InputValidator().validateInputReservationMenu(input)
            println(input)
        }
        return input
    }
}