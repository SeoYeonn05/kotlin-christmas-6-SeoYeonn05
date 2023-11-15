package christmas.util

import christmas.util.constant.ErrorConstants
import christmas.validation.exception.IllegalDateException
import christmas.validation.exception.IllegalMenuException
import java.text.DecimalFormat

class DataFormatter {
    fun parseToIntDate(input: String): Int {
        val intData = input.toIntOrNull() ?: throw IllegalDateException.invalidRangeDate
        if (intData < 0) {
            throw IllegalDateException.invalidRangeDate
        }
        return intData
    }

    fun formatNumberToDecimal(num: Int): String {
        val dec = DecimalFormat("#,###")
        return dec.format(num)
    }

    fun parseToIntMenuCount(input: String): Int {
        val intMenuCount = input.toIntOrNull() ?: throw IllegalMenuException.invalidMenuCount
        if (intMenuCount < 0) {
            throw IllegalMenuException.invalidMenuCount
        }
        return intMenuCount
    }
}