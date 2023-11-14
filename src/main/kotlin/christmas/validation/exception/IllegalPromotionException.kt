package christmas.validation.exception

import christmas.util.constant.ErrorConstants

class IllegalPromotionException(
    private val errorMessage: String
) : IllegalStateException(errorMessage) {

    override val message: String
        get() = "${ErrorConstants.ERROR_MESSAGE} $errorMessage"

    companion object {
        val invalidPromotion = IllegalPromotionException(ErrorConstants.INVALID_PROMOTION_ERROR)
    }
}
