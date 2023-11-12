package christmas.view

import christmas.util.constant.Constants

class Printer {
    internal fun printStartMessage() {
        println(Constants.START_MESSAGE)
    }
    fun printRequestReservationDateMessage(){
        print(Constants.REQUEST_RESERVATION_DATE)
    }
    fun printRequestReservationMenuMessage(){
        println(Constants.REQUEST_RESERVATION_MENU)
    }
    fun printPreviewPromotionMessage(){
        println(Constants.PROMOTION_BENEFITS_PREVIEW)
    }
    fun printOrderedMenuMessage(){
        println(Constants.ORDERED_MENU)
    }
    fun printTotalOrderAmountBeforeDiscountMessage(){
        println(Constants.TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT)
    }
    fun printGiveawayMenuMessage(){
        println(Constants.GIVEAWAY_MENU)
    }
    fun printBenefitDetailsMessage(){
        println(Constants.BENEFIT_DETAILS)
    }
    fun printTotalBenefitAmountMessage(){
        println(Constants.TOTAL_BENEFIT_AMOUNT)
    }
    fun printExpectedPaymentAfterDiscountMessage(){
        println(Constants.EXPECTED_PAYMENT_AFTER_DISCOUNT)
    }
    fun printDecemberEventBadgeMessage(){
        println(Constants.DECEMBER_EVENT_BADGE)
    }
}
