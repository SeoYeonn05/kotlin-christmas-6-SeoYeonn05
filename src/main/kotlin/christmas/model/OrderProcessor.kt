package christmas.model


class OrderProcessor(
    private val inputDate: String,
    private val orderedMenus: MutableList<MenuOrder>,
) {
    private var promotionDate: PromotionDate = PromotionDate(inputDate)
    private var totalOrderPrice: Int = 0
    private val availablePromotions: MutableList<DiscountPromotion> = promotionDate.getAvailablePromotions()
    private val promotionApplicator: PromotionApplicator =
        PromotionApplicator(promotionDate.getReservationDate(), availablePromotions, orderedMenus)

    init{
        calculateTotalOrderPrice()
    }
    fun getTotalOrderPrice() = totalOrderPrice


    private fun calculateTotalOrderPrice(){
        orderedMenus.forEach { menuOrder ->
            totalOrderPrice += menuOrder.calculateMenuAmount()
        }
    }

    fun getPromotionHistory(): MutableMap<DiscountPromotion, Int> {
        if (checkPromotionConditions()) {
            return promotionApplicator.applyPromotion()
        }
        return mutableMapOf(
            DiscountPromotion.NO_PROMOTION to 0
        )
    }

    private fun checkPromotionConditions(): Boolean {
        return checkTotalOrderPriceDiscount()
    }

    private fun checkTotalOrderPriceDiscount(): Boolean {
        return totalOrderPrice >= MINIMUM_TOTAL_ORDER_AMOUNT
    }

    companion object {
        private const val MINIMUM_TOTAL_ORDER_AMOUNT = 10000
    }
}