package christmas.view

import christmas.util.DataFormatter
import christmas.constants.Constants
import christmas.model.*
import christmas.model.receipt.Receipt

class OutputView(private val receipt: Receipt) {
    private val print = Printer()
    private val format = DataFormatter()

    fun printReceipt() {
        printPreviewMessage()
        printOrderedMenu(receipt.orderedMenus())
        printTotalAmount(receipt.totalAmount())
        printGiveaway(receipt.giveawayItem())
        printTotalBenefitAmount(receipt.totalBenefitAmount())
        printDiscountMessage(receipt.giveawayItem(), receipt.promotionHistory())
        printTotalPaymentAmount(receipt.totalPaymentAmount())
        printEventBadge(receipt.promotionBadge().badgeName)
    }

    private fun printPreviewMessage() {
        print.printPreviewPromotionMessage()
    }

    private fun printOrderedMenu(orderedMenu: List<Order>) {
        print.printOrderedMenuMessage()
        orderedMenu.forEach {
            println("${it.getMenu().itemName} ${it.getCount()}${Constants.UNIT}")
        }
    }

    private fun printTotalAmount(totalOrderedAmountBeforeDiscount: Int) {
        print.printTotalOrderAmountBeforeDiscountMessage()
        if (totalOrderedAmountBeforeDiscount == 0) {
            println(Constants.NO_VALUE)
        } else{
            val formatTotalOrderAmount = format.formatNumberToDecimal(totalOrderedAmountBeforeDiscount)
            println("$formatTotalOrderAmount${Constants.WON}")
        }
    }

    private fun printGiveaway(giveaway: GiveawayItem) {
        print.printGiveawayMenuMessage()
        if (giveaway == GiveawayItem.NO_GIVEAWAY) {
            println("${giveaway.getGiveaway()}")
        } else {
            println("${giveaway.getGiveaway()} 1${Constants.UNIT}")
        }
    }

    private fun printDiscountMessage(
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
            val formatAmount = format.formatNumberToDecimal(giveaway.giveawayAmount())

            println("${Constants.GIVEAWAY_PROMOTION} -${formatAmount}${Constants.WON}")
        }
    }

    private fun printDiscountDetail(promotionType: String, discountAmount: Int) {
        val formatAmount = format.formatNumberToDecimal(discountAmount)

        println("$promotionType -$formatAmount${Constants.WON}")
    }

    private fun printTotalBenefitAmount(totalBenefitAmount: Int) {
        print.printTotalBenefitAmountMessage()
        if (totalBenefitAmount != 0){
            val formatTotalBenefitAmount = format.formatNumberToDecimal(totalBenefitAmount)
            println("-$formatTotalBenefitAmount${Constants.WON}")
        }else{
            println("$totalBenefitAmount${Constants.WON}")
        }

    }

    private fun printTotalPaymentAmount(paymentAmount: Int) {
        print.printExpectedPaymentAfterDiscountMessage()
        val formatExpectedPayment = format.formatNumberToDecimal(paymentAmount)
        println("$formatExpectedPayment${Constants.WON}")
    }

    private fun printEventBadge(eventBadge: String) {
        print.printDecemberEventBadgeMessage()
        println(eventBadge)
    }
}