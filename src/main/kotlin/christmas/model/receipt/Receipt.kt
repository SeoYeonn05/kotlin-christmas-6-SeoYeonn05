package christmas.model.receipt

import christmas.model.Badge
import christmas.model.DiscountPromotion
import christmas.model.GiveawayItem
import christmas.model.order.Order


// 주문 계산 결과를 데이터 클래스로 관리하는 게 맞을까?
// 이게 맞으면 OutputView로 보내서 사용할 때는 어떻게 해야될까?
data class Receipt(
    private val orders: MutableList<Order>,
    private val totalAmount: Int,
    private val giveawayItem: GiveawayItem,
    private val promotionResult: MutableMap<DiscountPromotion, Int>,
    private val totalBenefitAmount: Int,
    private val totalPromotionAmount: Int,
    private val promotionBadge: Badge
) {
    private var totalPaymentAmount = 0

    init {
        calculateTotalAmountAfterPromotion()
    }

    fun totalAmount() = totalAmount
    fun orderedMenus() = orders
    fun promotionHistory() = promotionResult
    fun giveawayItem() = giveawayItem
    fun totalBenefitAmount() = totalBenefitAmount
    fun totalPaymentAmount() = totalPaymentAmount
    fun promotionBadge() = promotionBadge
    private fun calculateTotalAmountAfterPromotion(){
        totalPaymentAmount =  totalAmount - totalPromotionAmount
    }
}