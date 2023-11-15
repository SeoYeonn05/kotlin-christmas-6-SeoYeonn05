package christmas.validation.exception

import christmas.util.constant.ErrorConstants
import kotlin.IllegalStateException

class IllegalMenuException(
    private val errorMessage: String
) : IllegalStateException(errorMessage) {

    override val message: String
        get() = "${ErrorConstants.ERROR_MESSAGE} $errorMessage"

    companion object {
        val invalidMenuItem = IllegalMenuException(ErrorConstants.INVALID_MENU_FORMAT_ERROR)
        val invalidMenuCount = IllegalMenuException(ErrorConstants.INVALID_MENU_FORMAT_ERROR)
        val invalidMenuFormat = IllegalMenuException(ErrorConstants.INVALID_MENU_FORMAT_ERROR)
        val duplicateMenuItem = IllegalMenuException(ErrorConstants.INVALID_MENU_FORMAT_ERROR)
        val onlyBeverageOrder = IllegalMenuException(ErrorConstants.INVALID_MENU_CONDITION_ERROR)
        val maximumOrderCount = IllegalMenuException(ErrorConstants.INVALID_MENU_COUNT_ERROR)
    }
}