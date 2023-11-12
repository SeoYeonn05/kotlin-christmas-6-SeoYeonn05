package christmas.view

import christmas.model.MenuOrder

class OutputView {
    private val print = Printer()

    fun printPreviewPromotionMessage(){
        print.printPreviewPromotionMessage()
    }
    fun printOrderedMenu(orderedMenu: List<MenuOrder>){
        print.printOrderedMenuMessage()

    }
    fun printTotalOrderAmountBeforeDiscount(totalOrderedAmountBeforeDiscount: Int){
        print.printTotalOrderAmountBeforeDiscountMessage()

    }
    fun printGiveaway(/**/){
        print.printGiveawayMenuMessage()

    }
    fun print(){
        print.printBenefitDetailsMessage()

    }
    fun printTotalBenefitAmount(totalBenefitAmount: Int){
        print.printTotalBenefitAmountMessage()

    }
    fun printExpectedPayment(expectedPayment: Int){
        print.printExpectedPaymentAfterDiscountMessage()

    }
    fun printDecemberEventBadge(totalBenefitAmount: Int){
        print.printDecemberEventBadgeMessage()

    }
}