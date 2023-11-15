package christmas.util

import christmas.util.constant.ErrorConstants
import christmas.validation.exception.IllegalDateException
import christmas.validation.exception.IllegalMenuException
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
    fun parseToIntMenuCount(input: String): Int {
        return try {
            val intMenuCount = input.toInt()
            if (intMenuCount < 0) {
                throw IllegalMenuException.invalidMenuCount
            }
            print("parseToIntMenu: $intMenuCount")
            intMenuCount
        } catch (e: NumberFormatException) {
            throw IllegalMenuException.invalidMenuCount
        }
    }
    companion object{
         val ERROR_NUM = -1
    }
}