package christmas.exception

import christmas.util.constant.ErrorConstants

class IllegalDateException(
    private val errorMessage: String
) : IllegalArgumentException(errorMessage) {

    override val message: String
        get() = "[ERROR] $errorMessage"

    companion object {
        val invalidNumericValue = IllegalArgumentException(ErrorConstants.INVALID_DATE_ERROR)
        val invalidRangeDate = IllegalArgumentException(ErrorConstants.INVALID_DATE_ERROR)
    }
}
