package christmas.validation

import christmas.util.DataFormatter
import christmas.validation.exception.IllegalDateException
import christmas.validation.exception.IllegalMenuException

class InputValidator {
    fun validateInputReservationDate(inputReservationDate: String):Boolean{
        val reservationDate = convertReservationDate(inputReservationDate)
        isReservationDatePositive(reservationDate)

        return true
    }

    fun validateInputReservationMenu(inputReservationMenu: String):Boolean{
        var reservationMenu = inputReservationMenu.split(",")
        reservationMenu.forEach {
            validateMenuOrder(it)
        }
        return true
    }

    private fun convertReservationDate(input: String): Int{
        return DataFormatter().parseToInt(input)
    }

    private fun validateMenuOrder(reservationMenu: String){
        val regex = Regex("^[가-힣A-Za-z]+-\\d+\$")
        if(!reservationMenu.matches(regex)){
            IllegalMenuException.invalidMenuFormat
        }
    }

    private fun isReservationDatePositive(input: Int) {
        require(input > 0) { IllegalDateException.invalidNumericValue }
    }

}