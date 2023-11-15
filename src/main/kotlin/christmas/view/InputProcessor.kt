package christmas.view

import christmas.util.InputHandler
import christmas.util.constant.ErrorConstants
import christmas.validation.InputValidator
import christmas.validation.exception.IllegalDateException
import christmas.validation.exception.IllegalMenuException

class InputProcessor {
    private val inputValidator = InputValidator()
    fun requestReservationDate(): String {
        while (true) {
            try {
                val userInput = InputHandler().inputHandler()
                println(userInput)
                InputValidator().validateInputReservationDate(userInput)
                return userInput
            } catch (e: IllegalDateException) {
                println(e.message)
            }
        }
    }

    fun requestReservationMenu(): String {
        while (true) {
            try {
                val userInput = InputHandler().inputHandler()
                println(userInput)
                inputValidator.validateInputReservationMenu(userInput)
                return userInput
            } catch (e: IllegalMenuException) {
                println(e.message)
            }
        }
    }
}