package christmas.controller

import christmas.model.*

import christmas.view.InputView
import christmas.view.OutputView

class PromotionController(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    private var totalAmount: Int = 0
    private var inputDate: String = ""
    var orderDataController = OrderDataController(inputView)

    fun run() {
        inputView.printStartMessage()
        inputDate = orderDataController.getOrderDate()
        var orderedMenus: MutableList<MenuOrder> = mutableListOf()
        do{
            orderedMenus = orderDataController.getOrderMenu()
        } while(orderedMenus.isEmpty())
        val receipt = ReceiptController(inputDate, orderedMenus).createReceipt()
        printTotalReceipt(receipt)
    }

    private fun printTotalReceipt(receipt: Receipt) {
        printPreviewMessage()
        printOrderMenu(receipt.orderedMenus())
        printTotalAmountBeforeDiscount(receipt.totalAmount())
        printGiveaway(receipt)
        printPromotionHistory(receipt)
        printTotalBenefitAmount(receipt.totalBenefitAmount())
        printTotalAmountAfterDiscount(receipt.totalAmountAfterPromotion())
        printPromotionBadge(receipt.promotionBadge())
    }

    private fun printPreviewMessage() {
        outputView.printPreviewPromotionMessage()
    }

    private fun printOrderMenu(orderedMenus: MutableList<MenuOrder>) {
        outputView.printOrderedMenu(orderedMenus)
    }

    private fun printTotalAmountBeforeDiscount(totalAmount: Int) {
        outputView.printTotalOrderAmountBeforeDiscount(totalAmount)
    }

    private fun printGiveaway(receipt: Receipt) {
        outputView.printGiveaway(receipt.giveawayItem())
    }

    private fun printPromotionHistory(receipt: Receipt) {
        outputView.printDiscountMessage(receipt.giveawayItem(), receipt.promotionHistory())
    }

    private fun printTotalBenefitAmount(allBenefitAmount: Int) {
        outputView.printTotalBenefitAmountAmount(allBenefitAmount)
    }

    private fun printTotalAmountAfterDiscount(totalAmountAfterPromotion: Int) {
        outputView.printTotalAmountAfterDiscount(totalAmountAfterPromotion)
    }

    private fun printPromotionBadge(badge: Badge) {
        outputView.printDecemberEventBadge(badge.badgeName)
    }
}