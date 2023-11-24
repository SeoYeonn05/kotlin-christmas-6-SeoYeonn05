package christmas.exception

import christmas.constants.ErrorConstants

class LimitedPromotionException (
    private val errorMessage: String
) : IllegalStateException(errorMessage) {

    override val message: String
        get() = "${ErrorConstants.ERROR_MESSAGE} $errorMessage"

    companion object {
        val limitedPromotion = LimitedPromotionException(ErrorConstants.LIMITED_PROMOTION_ERROR)
    }
}
