package christmas.validation.exception

import christmas.util.constant.ErrorConstants
import kotlin.IllegalStateException

class IllegalMenuException(
    private val errorMessage: String
) : IllegalArgumentException(errorMessage) {

    override val message: String
        get() = "${ErrorConstants.ERROR_MESSAGE} $errorMessage"

    companion object {
        val invalidMenuItem = IllegalStateException(ErrorConstants.INVALID_MENU_ERROR)
        val nonPositiveMenuCount = IllegalStateException(ErrorConstants.INVALID_MENU_ERROR)
        val invalidMenuFormat = IllegalStateException(ErrorConstants.INVALID_MENU_ERROR)
        val duplicateMenuItem = IllegalStateException(ErrorConstants.INVALID_MENU_ERROR)
    }
}