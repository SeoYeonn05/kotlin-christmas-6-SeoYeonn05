package christmas.controller

import christmas.model.*

import christmas.view.InputView
import christmas.view.OutputView

class PromotionController(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    private lateinit var orderedMenus: MutableList<MenuOrder>
    private lateinit var availablePromotions: MutableList<DiscountPromotion>
    private lateinit var orderProcessor: OrderProcessor
    private var reservationDate: Int = 0
    private var totalAmount: Int = 0

    fun run() {
        getOrderData()
        val receipt = createReceipt()
        printTotalReceipt(receipt)
    }

    private fun getOrderData(){
        inputView.printStartMessage()
        val inputDate = getReservationDate()
        val inputOrder = getReservationOrder()
        createMenuOrder(inputOrder)
        checkAvailablePromotion(inputDate)
    }

    private fun getReservationDate(): String {
        return inputView.requestReservationDate()
    }
    private fun getReservationOrder(): String {
        return inputView.requestReservationMenu()
    }
    private fun createMenuOrder(inputOrder: String) {
        orderedMenus = MenuManager(inputOrder).getOrderedMenu()
    }
    private fun checkAvailablePromotion(inputDate: String) {
        val promotionDate: PromotionDate = PromotionDate(inputDate)
        availablePromotions = promotionDate.getAvailablePromotions()
        reservationDate = promotionDate.getReservationDate()
    }

    private fun createReceipt(): Receipt{
        val totalAmount = calculateTotalAmount()
        val giveaway = checkGiveaway()
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
    private fun calculateTotalAmount():Int {
        orderProcessor = OrderProcessor(reservationDate, orderedMenus, availablePromotions)
        return orderProcessor.getTotalOrderPrice()
    }
    private fun checkGiveaway():GiveawayItem {
        return PromotionGiveaway(totalAmount).getGiveawayByAmount()
    }
    private fun getPromotionHistory():MutableMap<DiscountPromotion, Int>{
        return orderProcessor.getDiscountAmount()
    }
    private fun calculateAllDiscountAmount(promotionalPrice: MutableMap<DiscountPromotion, Int>):Int{
        var allDiscountAmount = 0
        promotionalPrice.forEach { (_, discountAmount) ->
            allDiscountAmount += discountAmount
        }
        return allDiscountAmount
    }
    private fun calculateAllBenefitAmount(giveawayItem: GiveawayItem, promotionalPrice: MutableMap<DiscountPromotion, Int>):Int{
        var allBenefitAmount = 0
        promotionalPrice.forEach { (_, discountAmount) ->
            allBenefitAmount += discountAmount
        }
        giveawayItem.applyGiveawayAMount(allBenefitAmount)
        return allBenefitAmount
    }
    private fun calculatePromotionBadge(allDiscountAmount: Int):Badge{
        return PromotionBadge(allDiscountAmount).givePromotionBadge()
    }


    private fun printTotalReceipt(receipt: Receipt){
        printPreviewMessage()
        printOrderMenu()
        printTotalAmountBeforeDiscount()
        printGiveaway()
        printPromotionHistory(receipt)
        printTotalBenefitAmount(receipt.totalBenefitAmount())
        printTotalAmountAfterDiscount(receipt.totalAmountAfterPromotion())
        printPromotionBadge(receipt.promotionBadge())
    }

    private fun printPreviewMessage() {
        outputView.printPreviewPromotionMessage()
    }

    private fun printOrderMenu() {
        outputView.printOrderedMenu(orderedMenus)
    }

    private fun printTotalAmountBeforeDiscount() {
        outputView.printTotalOrderAmountBeforeDiscount(totalAmount)
    }

    private fun printGiveaway() {
        outputView.printGiveaway(checkGiveaway())
    }

    private fun printPromotionHistory(receipt: Receipt) {
        outputView.printDiscountMessage(receipt.giveawayItem(), receipt.promotionHistory())
    }
    private fun printTotalBenefitAmount(allBenefitAmount: Int){
        outputView.printTotalBenefitAmountAmount(allBenefitAmount)
    }
    private fun printTotalAmountAfterDiscount(totalAmountAfterPromotion: Int){
        outputView.printTotalBenefitAmountAmount(totalAmountAfterPromotion)
    }
    private fun printPromotionBadge(badge: Badge){
        outputView.printDecemberEventBadge(badge.badgeName)
    }
}