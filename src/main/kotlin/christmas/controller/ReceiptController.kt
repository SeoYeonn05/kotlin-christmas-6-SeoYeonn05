package christmas.controller

import christmas.model.*
import christmas.model.order.OrderContent
import christmas.model.promotion.PromotionApplicator
import christmas.model.receipt.Receipt

class ReceiptController(
    private val orderContent: OrderContent
) {
    private lateinit var receipt: Receipt

    init{
        createReceipt()
    }
    fun getReceipt() = receipt
    private fun createReceipt() {
        val totalAmount = calculateTotalAmount()
        val giveaway = PromotionGiveaway(totalAmount).getGiveawayByAmount()
        val promotionResult = PromotionApplicator(orderContent, calculateTotalAmount()).getPromotionResult()
        val allDiscountAmount = calculateAllDiscountAmount(promotionResult)
        val amountBenefitDiscount = calculateAllBenefitAmount(giveaway, promotionResult)
        val promotionBadge = PromotionBadge(amountBenefitDiscount).givePromotionBadge()
        receipt = Receipt(
            orders = orderContent.orders,
            totalAmount = totalAmount,
            giveawayItem = giveaway,
            promotionResult = promotionResult,
            totalBenefitAmount = amountBenefitDiscount,
            totalPromotionAmount = allDiscountAmount,
            promotionBadge = promotionBadge
        )
    }

    private fun calculateTotalAmount():Int {
        var totalOrderPrice = 0
        orderContent.orders.forEach { order ->
            totalOrderPrice += order.calculateMenuAmount()
        }
        return totalOrderPrice
    }

    private fun calculateAllDiscountAmount(promotionResult: MutableMap<DiscountPromotion, Int>): Int {
        var allDiscountAmount = 0
        promotionResult.forEach { (_, discountAmount) ->
            allDiscountAmount += discountAmount
        }
        return allDiscountAmount
    }


    private fun calculateAllBenefitAmount(
        giveawayItem: GiveawayItem,
        promotionalPrice: MutableMap<DiscountPromotion, Int>
    ): Int {
        var allBenefitAmount = 0
        promotionalPrice.forEach { (_, discountAmount) ->
            allBenefitAmount += discountAmount
        }
        return allBenefitAmount + giveawayItem.giveawayAmount()
    }
}