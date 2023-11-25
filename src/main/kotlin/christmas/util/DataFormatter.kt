package christmas.util

import christmas.exception.IllegalDateException
import christmas.exception.IllegalMenuException
import java.text.DecimalFormat

class DataFormatter {
    fun parseToIntDate(input: String): Int {
        return try {
            val intData = input.toInt()
            if (intData < 0) {
                throw IllegalDateException.invalidRangeDate
            }
            intData
        } catch (e: NumberFormatException) {
            throw IllegalDateException.invalidRangeDate
        }
    }

    fun formatNumberToDecimal(num: Int): String {
        val dec = DecimalFormat("#,###")
        return dec.format(num)
    }

    // 이거 예외처리 어떻게 하면 좋을까?
    fun stringToInt(input: String): Int {
        return try {
            input.toInt()
        } catch (e: NumberFormatException) {
            ERROR_NUM
        }
    }

    companion object {
        const val ERROR_NUM = -1
    }
}