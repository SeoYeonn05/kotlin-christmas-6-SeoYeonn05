package christmas.exception

import christmas.constants.ErrorConstants

class IllegalDateException(
    private val errorMessage: String
) : IllegalArgumentException(errorMessage) {

    override val message: String
        get() = "${ErrorConstants.ERROR_MESSAGE} $errorMessage"

    companion object {
        val invalidNumericValue = IllegalDateException(ErrorConstants.INVALID_DATE_ERROR)
        val invalidRangeDate = IllegalDateException(ErrorConstants.INVALID_DATE_ERROR)
    }
}
