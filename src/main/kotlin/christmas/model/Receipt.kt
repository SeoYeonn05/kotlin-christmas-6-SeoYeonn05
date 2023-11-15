package christmas.model

class Receipt(
    private val orderedMenus: MutableList<MenuOrder>,
    private val totalAmount: Int,
    private val giveawayItem: GiveawayItem,
    private val promotionHistory: MutableMap<DiscountPromotion, Int>,
    private val totalBenefitAmount: Int,
    private val totalPromotionAmount: Int,
    private val promotionBadge: Badge
) {
    private var totalAmountAfterPromotion = 0

    init {
        calculateTotalAmountAfterPromotion()
    }

    fun totalAmount() = totalAmount
    fun orderedMenus() = orderedMenus
    fun promotionHistory() = promotionHistory
    fun giveawayItem() = giveawayItem
    fun totalBenefitAmount() = totalBenefitAmount
    fun totalAmountAfterPromotion() = totalAmountAfterPromotion
    fun promotionBadge() = promotionBadge
    private fun calculateTotalAmountAfterPromotion(){
        totalAmountAfterPromotion =  totalAmount - totalPromotionAmount
    }
}