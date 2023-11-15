package christmas.view

import christmas.model.DayOfWeekType
import christmas.model.DiscountPromotion
import christmas.model.GiveawayItem
import christmas.model.MenuOrder
import christmas.util.DataFormatter
import christmas.util.constant.Constants

class OutputView {
    private val print = Printer()
    private val format = DataFormatter()

    fun printPreviewPromotionMessage() {
        print.printPreviewPromotionMessage()
    }

    fun printOrderedMenu(orderedMenu: List<MenuOrder>) {
        print.printOrderedMenuMessage()
        orderedMenu.forEach {
            println("${it.getMenuItem().getMenuName()} ${it.getOrderedMenuCount()}${Constants.UNIT}")
        }
    }

    fun printTotalOrderAmountBeforeDiscount(totalOrderedAmountBeforeDiscount: Int) {
        print.printTotalOrderAmountBeforeDiscountMessage()
        if (totalOrderedAmountBeforeDiscount == 0) {
            println(Constants.NO_VALUE)
        } else{
            val formatTotalOrderAmount = format.formatNumberToDecimal(totalOrderedAmountBeforeDiscount)
            println("$formatTotalOrderAmount${Constants.WON}")
        }
    }

    fun printGiveaway(giveaway: GiveawayItem) {
        print.printGiveawayMenuMessage()
        if (giveaway == GiveawayItem.NO_GIVEAWAY) {
            println("${giveaway.getGiveaway()}")
        } else {
            println("${giveaway.getGiveaway()} 1${Constants.UNIT}")
        }
    }

    fun printDiscountMessage(
        giveaway: GiveawayItem,
        discountAmount: MutableMap<DiscountPromotion, Int>
    ) {
        print.printBenefitDetailsMessage()
        discountAmount.forEach { (discountPromotion, discountAmount) ->
            when (discountPromotion) {
                DiscountPromotion.CHRISTMAS_D_DAY_DISCOUNT_PROMOTION
                -> printDiscountDetail(Constants.CHRISTMAS_D_DAY_DISCOUNT, discountAmount)
                DiscountPromotion.WEEKDAY_DISCOUNT_PROMOTION
                -> printDiscountDetail(Constants.WEEKDAY_DISCOUNT, discountAmount)
                DiscountPromotion.WEEKEND_DISCOUNT_PROMOTION
                -> printDiscountDetail(Constants.WEEKEND_DISCOUNT, discountAmount)
                DiscountPromotion.SPECIAL_DISCOUNT_PROMOTION
                -> printDiscountDetail(Constants.SPECIAL_DISCOUNT, discountAmount)
                DiscountPromotion.NO_PROMOTION -> println(Constants.NO_VALUE)
            }
        }
        if (giveaway != GiveawayItem.NO_GIVEAWAY) {
            println("${Constants.GIVEAWAY_PROMOTION} -${giveaway.getGiveaway()}${Constants.WON}")
        }
    }

    private fun printDiscountDetail(promotionType: String, discountAmount: Int) {
        println("$promotionType -$discountAmount${Constants.WON}")
    }

    fun printTotalBenefitAmountAmount(totalBenefitAmount: Int) {
        print.printTotalBenefitAmountMessage()
        if (totalBenefitAmount != 0){
            val formatTotalBenefitAmount = format.formatNumberToDecimal(totalBenefitAmount)
            println("-$formatTotalBenefitAmount${Constants.WON}")
        }else{
            println("$totalBenefitAmount${Constants.WON}")
        }

    }

    fun printTotalAmountAfterDiscount(expectedPayment: Int) {
        print.printExpectedPaymentAfterDiscountMessage()
        val formatExpectedPayment = format.formatNumberToDecimal(expectedPayment)
        println("$formatExpectedPayment${Constants.WON}")
    }

    fun printDecemberEventBadge(eventBadge: String) {
        print.printDecemberEventBadgeMessage()
        println(eventBadge)
    }
}