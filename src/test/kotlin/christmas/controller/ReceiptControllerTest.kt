/*
package christmas.controller

import christmas.model.MenuOrder
import org.junit.jupiter.api.Test

import christmas.model.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class ReceiptControllerTest {
    @Test
    fun `크리스마스 날 주문 메뉴 영수증`() {
        val inputDate = "25"
        val orderedMenus = mutableListOf(
            MenuOrder(MenuItem.T_BONE_STEAK, 3),
            MenuOrder(MenuItem.TAPAS, 1)
        )

        val receiptController = ReceiptController(inputDate, orderedMenus)

        val receipt = receiptController.createReceipt()

        assertEquals(orderedMenus, receipt.orderedMenus())
        assertEquals(170500, receipt.totalAmount())
        assertEquals(GiveawayItem.CHAMPAGNE, receipt.giveawayItem())
        assertEquals(
            mutableMapOf(
                DiscountPromotion.CHRISTMAS_D_DAY_DISCOUNT_PROMOTION to 3400,
                DiscountPromotion.WEEKDAY_DISCOUNT_PROMOTION to 0,
                DiscountPromotion.SPECIAL_DISCOUNT_PROMOTION to 1000
            ), receipt.promotionHistory()
        )
        assertEquals(4400, receipt.totalBenefitAmount())
        assertEquals(166100, receipt.totalAmountAfterPromotion())
        assertEquals(Badge.NO_BADGE, receipt.promotionBadge())
    }

    @Test
    fun `12월 7일 주문 메뉴 영수증`() {
        val inputDate = "7"
        val orderedMenus = mutableListOf(
            MenuOrder(MenuItem.T_BONE_STEAK, 3),
            MenuOrder(MenuItem.TAPAS, 1),
            MenuOrder(MenuItem.CHOCOLATE_CAKE, 2),
            MenuOrder(MenuItem.ZERO_COLA, 4)
        )

        val receiptController = ReceiptController(inputDate, orderedMenus)

        val receipt = receiptController.createReceipt()

        assertEquals(orderedMenus, receipt.orderedMenus())
        assertEquals(212500, receipt.totalAmount())
        assertEquals(GiveawayItem.CHAMPAGNE, receipt.giveawayItem())
        assertEquals(
            mutableMapOf(
                DiscountPromotion.CHRISTMAS_D_DAY_DISCOUNT_PROMOTION to 1600,
                DiscountPromotion.WEEKDAY_DISCOUNT_PROMOTION to 4046,
            ), receipt.promotionHistory()
        )
        assertEquals(5646, receipt.totalBenefitAmount())
        assertEquals(206854, receipt.totalAmountAfterPromotion())
        assertEquals(Badge.STAR, receipt.promotionBadge())
    }
}
*/
