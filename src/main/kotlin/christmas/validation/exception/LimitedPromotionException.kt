package christmas.validation.exception

import christmas.util.constant.ErrorConstants

class LimitedPromotionException (
    private val errorMessage: String
) : IllegalStateException(errorMessage) {

    override val message: String
        get() = "${ErrorConstants.ERROR_MESSAGE} $errorMessage"

    companion object {
        val limitedPromotion = LimitedPromotionException(ErrorConstants.LIMITED_PROMOTION_ERROR)
    }
}
