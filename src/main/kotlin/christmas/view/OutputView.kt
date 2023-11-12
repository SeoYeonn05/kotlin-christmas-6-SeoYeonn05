package christmas.view

import christmas.model.MenuOrder
import christmas.util.DataFormatter
import christmas.util.constant.Constants
import java.text.Format

class OutputView {
    private val print = Printer()
    private val format = DataFormatter()

    fun printPreviewPromotionMessage(){
        print.printPreviewPromotionMessage()
    }
    fun printOrderedMenu(orderedMenu: List<MenuOrder>){
        print.printOrderedMenuMessage()
        orderedMenu.forEach {
            println("${it.printMenuItem()} ${it.printOrderedMenuCount()}${Constants.UNIT}")
        }
    }
    fun printTotalOrderAmountBeforeDiscount(totalOrderedAmountBeforeDiscount: Int){
        print.printTotalOrderAmountBeforeDiscountMessage()
        if(totalOrderedAmountBeforeDiscount == 0){
            println(Constants.NO_VALUE)
        }
        val formatTotalOrderAmount = format.formatNumberToDecimal(totalOrderedAmountBeforeDiscount)
        println("$formatTotalOrderAmount$Constants.WON")

    }
    fun printGiveaway(/**/){
        print.printGiveawayMenuMessage()

    }
    fun printBenefitDetailsMessage(){
        print.printBenefitDetailsMessage()
    }
    fun printTotalBenefitAmount(totalBenefitAmount: Int){
        print.printTotalBenefitAmountMessage()
        val formatTotalBenefitAmount = format.formatNumberToDecimal(totalBenefitAmount)
        println("$formatTotalBenefitAmount$Constants.WON")
    }
    fun printExpectedPayment(expectedPayment: Int){
        print.printExpectedPaymentAfterDiscountMessage()
        val formatExpectedPayment = format.formatNumberToDecimal(expectedPayment)
        println("$formatExpectedPayment$Constants.WON")
    }
    fun printDecemberEventBadge(eventBadge: String){
        print.printDecemberEventBadgeMessage()

    }
}