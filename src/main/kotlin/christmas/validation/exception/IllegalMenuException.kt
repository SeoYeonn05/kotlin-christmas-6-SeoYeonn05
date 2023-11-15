package christmas.validation.exception

import christmas.util.constant.ErrorConstants
import kotlin.IllegalStateException

class IllegalMenuException(
    private val errorMessage: String
) : IllegalStateException(errorMessage) {

    override val message: String
        get() = "${ErrorConstants.ERROR_MESSAGE} $errorMessage"

    companion object {
        val invalidMenuItem = IllegalMenuException(ErrorConstants.INVALID_MENU_ERROR)
        val invalidMenuCount = IllegalMenuException(ErrorConstants.INVALID_MENU_ERROR)
        val invalidMenuFormat = IllegalMenuException(ErrorConstants.INVALID_MENU_ERROR)
        val duplicateMenuItem = IllegalMenuException(ErrorConstants.INVALID_MENU_ERROR)
    }
}