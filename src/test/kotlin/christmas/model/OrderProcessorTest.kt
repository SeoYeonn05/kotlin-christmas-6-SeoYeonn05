package christmas.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OrderProcessorTest {
    private var inputDate = "3"
    private var christmasDate = "25"
    private var orderedMenu1 = mutableListOf<MenuOrder>(
        MenuOrder(MenuItem.T_BONE_STEAK, 1),
        MenuOrder(MenuItem.BBQ_RIBS, 1),
    )
    private var orderedMenu2 = mutableListOf<MenuOrder>(
        MenuOrder(MenuItem.CAESAR_SALAD, 1),
    )
    private var orderedMenu3 = mutableListOf<MenuOrder>(
        MenuOrder(MenuItem.TAPAS, 3),
        MenuOrder(MenuItem.T_BONE_STEAK, 1),
        MenuOrder(MenuItem.BBQ_RIBS, 1),
        MenuOrder(MenuItem.ICE_CREAM, 2),
        MenuOrder(MenuItem.CHAMPAGNE, 3),
    )

    @Test
    fun `총 주문 금액 반환`() {
        val orderProcessor = OrderProcessor(inputDate, orderedMenu1)

        val totalAmount = orderProcessor.getTotalOrderPrice()
        assertEquals(109000, totalAmount)
    }

    @Test
    fun `10000원 이하 구매 시 이벤트 대상 제외 확인`() {
        val orderProcessor = OrderProcessor(inputDate, orderedMenu2)

        val expectedPromotion = mutableMapOf(DiscountPromotion.NO_PROMOTION to 0)
        val applyPromotion = orderProcessor.getPromotionHistory()
        assertEquals(expectedPromotion, applyPromotion)
    }

    @Test
    fun `이벤트 조건 충족 시 이벤트 적용 여부 및 할인된 가격 확인 `() {
        val orderProcessor = OrderProcessor(inputDate, orderedMenu1)

        val expectedPromotion =
            mutableMapOf(
                DiscountPromotion.CHRISTMAS_D_DAY_DISCOUNT_PROMOTION to 1200,
                DiscountPromotion.WEEKDAY_DISCOUNT_PROMOTION to 0,
                DiscountPromotion.SPECIAL_DISCOUNT_PROMOTION to 1000
            )
        val applyPromotion = orderProcessor.getPromotionHistory()
        assertEquals(expectedPromotion, applyPromotion)
    }
    @Test
    fun `크리스마스 당일 이벤트 적용 여부 및 할인된 가격 확인 `() {
        val orderProcessor = OrderProcessor(christmasDate, orderedMenu3)

        val expectedPromotion =
            mutableMapOf(
                DiscountPromotion.CHRISTMAS_D_DAY_DISCOUNT_PROMOTION to 3400,
                DiscountPromotion.WEEKDAY_DISCOUNT_PROMOTION to 4046,
                DiscountPromotion.SPECIAL_DISCOUNT_PROMOTION to 1000
            )
        val applyPromotion = orderProcessor.getPromotionHistory()
        assertEquals(expectedPromotion, applyPromotion)
    }
}