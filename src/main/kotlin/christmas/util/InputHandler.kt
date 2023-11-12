package christmas.util

import camp.nextstep.edu.missionutils.Console
import christmas.validation.exception.EmptyFieldException
import christmas.validation.exception.IllegalDateException

class InputHandler {
    fun inputHandler(validateInput: (String) -> Boolean): String {
        var input: String
        do {
            input = Console.readLine()
            if (input.isBlank()) {
                EmptyFieldException.emptyField
            }
        } while (!validateInput(input))
        return input
    }

    fun example() {
        inputHandler { input ->
            val isValid = input.all { it.isLetter() }
            if(!isValid){
                IllegalDateException
            }
            isValid
        }
    }
}