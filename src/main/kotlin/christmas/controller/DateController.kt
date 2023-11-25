package christmas.controller

import christmas.constants.Constants
import christmas.exception.IllegalDateException
import christmas.util.DataFormatter


class DateController(
    private val dateInput: String
) {
    private var date: Int = 0

    init{
        if (!validDateFormat(dateInput)){
            throw IllegalDateException.invalidNumericValue
        }
        convertInputToDate(dateInput)
        Constants.setDateToPreview(date)
        if (!validDateLogic(date)){
            throw IllegalDateException.invalidRangeDate
        }
    }

    fun getData(): Int = date

    private fun validDateFormat(dateInput: String): Boolean {
        return isNotBlank(dateInput) && isNumeric(dateInput)
    }

    private fun validDateLogic(date: Int): Boolean {
        return checkDateRange(date)
    }

    private fun convertInputToDate(dateInput: String) {
        date = DataFormatter().parseToIntDate(dateInput)
    }

    private fun isNotBlank(input: String) = input.isNotBlank()
    private fun isNumeric(input: String) = input.all { it.isDigit() }
    private fun checkDateRange(date: Int) = date in MIN_DAY..MAX_DAY

    companion object {
        const val MIN_DAY = 1
        const val MAX_DAY = 31
    }
}