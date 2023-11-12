package christmas.util

import christmas.util.constant.ErrorConstants

class DataFormatter {
    fun parseToInt(input: String): Int {
        return try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw java.lang.IllegalArgumentException("${ErrorConstants.ERROR_MESSAGE} $ErrorConstants.EMPTY_VALUE_ERROR")
        }
    }
}