package christmas.controller

import christmas.model.*

class ReceiptController(
    private val inputDate: String,
    private val orderedMenus: MutableList<MenuOrder>,
) {
    private lateinit var orderProcessor: OrderProcessor

    fun createReceipt(): Receipt {
        val totalAmount = calculateTotalAmount(orderedMenus)
        val giveaway = checkGiveaway(totalAmount)
        val promotionHistory = getPromotionHistory()
        val allDiscountAmount = calculateAllDiscountAmount(promotionHistory)
        val amountBenefitDiscount = calculateAllBenefitAmount(giveaway, promotionHistory)
        val promotionBadge = calculatePromotionBadge(allDiscountAmount)
        return Receipt(
            orderedMenus = orderedMenus,
            totalAmount = totalAmount,
            giveawayItem = giveaway,
            promotionHistory = promotionHistory,
            totalBenefitAmount = amountBenefitDiscount,
            totalPromotionAmount = allDiscountAmount,
            promotionBadge = promotionBadge
        )
    }

    private fun calculateTotalAmount(orderedMenus: MutableList<MenuOrder>): Int {
        orderProcessor = OrderProcessor(inputDate, orderedMenus)
        return orderProcessor.getTotalOrderPrice()
    }

    private fun getPromotionHistory(): MutableMap<DiscountPromotion, Int> {
        return orderProcessor.getPromotionHistory()
    }

    private fun calculateAllDiscountAmount(promotionalPrice: MutableMap<DiscountPromotion, Int>): Int {
        var allDiscountAmount = 0
        promotionalPrice.forEach { (_, discountAmount) ->
            allDiscountAmount += discountAmount
        }
        return allDiscountAmount
    }

    private fun checkGiveaway(totalAmount: Int): GiveawayItem {
        return PromotionGiveaway(totalAmount).getGiveawayByAmount()
    }

    private fun calculateAllBenefitAmount(
        giveawayItem: GiveawayItem,
        promotionalPrice: MutableMap<DiscountPromotion, Int>
    ): Int {
        var allBenefitAmount = 0
        promotionalPrice.forEach { (_, discountAmount) ->
            allBenefitAmount += discountAmount
        }
        giveawayItem.applyGiveawayAMount(allBenefitAmount)
        return allBenefitAmount
    }

    private fun calculatePromotionBadge(allDiscountAmount: Int): Badge {
        return PromotionBadge(allDiscountAmount).givePromotionBadge()
    }
}