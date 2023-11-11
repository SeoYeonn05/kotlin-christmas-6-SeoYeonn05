package christmas.util

import christmas.util.constant.ErrorConstants
import christmas.validation.exception.IllegalDateException


private fun parseToInt(input: String): Int {
    return try {
        input.toInt()
    } catch (e: NumberFormatException) {
        throw java.lang.IllegalArgumentException("${ErrorConstants.ERROR_MESSAGE} $ErrorConstants.EMPTY_VALUE_ERROR")
    }
}