package christmas.validation.exception

import christmas.util.constant.ErrorConstants

class EmptyFieldException(
    private val errorMessage: String
) : IllegalArgumentException(errorMessage) {

    override val message: String
        get() = "${ErrorConstants.ERROR_MESSAGE} $errorMessage"

    companion object {
        val emptyField = EmptyFieldException(ErrorConstants.EMPTY_VALUE_ERROR)
    }
}