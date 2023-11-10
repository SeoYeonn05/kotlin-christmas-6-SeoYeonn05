package christmas.exception

import christmas.util.constant.ErrorConstants

class EmptyFieldException(
    private val errorMessage: String
) : IllegalArgumentException(errorMessage) {

    override val message: String
        get() = "[ERROR] $errorMessage"

    companion object {
        val emptyField = EmptyFieldException(ErrorConstants.EMPTY_VALUE_ERROR)
    }
}