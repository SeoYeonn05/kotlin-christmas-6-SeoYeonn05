package christmas.util

import camp.nextstep.edu.missionutils.Console

class InputHandler {
    fun inputHandler(): String {
        var input: String
        do {
            input = Console.readLine()
        } while (!isNotEmptyValue(input))

        return input
    }

    private fun isNotEmptyValue(input: String): Boolean {
        return input.isNotEmpty()
    }
}
