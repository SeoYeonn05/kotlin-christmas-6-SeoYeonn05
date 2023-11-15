package christmas.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PromotionApplicatorTest {
    var orderedMenu = mutableListOf<MenuOrder>(
        MenuOrder(MenuItem.T_BONE_STEAK, 1),
        MenuOrder(MenuItem.BBQ_RIBS, 1),
        MenuOrder(MenuItem.CHOCOLATE_CAKE, 2),
    )

    @Test
    fun `크리스마스 디데이 이벤트 적용 시 할인 금액이 올바르게 계산되는지 확인`() {
        val promotionApplicator = PromotionApplicator(
            reservationDate = 24,
            availablePromotions = mutableListOf(DiscountPromotion.CHRISTMAS_D_DAY_DISCOUNT_PROMOTION),
            orderedMenus = orderedMenu
        )

        val expectedDiscountAmount = 3300
        val christmasPromotionMap = promotionApplicator.applyPromotion()
        val actualDiscountAmount =
            christmasPromotionMap[DiscountPromotion.CHRISTMAS_D_DAY_DISCOUNT_PROMOTION]

        assertEquals(expectedDiscountAmount, actualDiscountAmount)
    }

    @Test
    fun `평일 할인 적용 시 할인 금액이 올바르게 계산되는지 확인`() {
        val promotionApplicator = PromotionApplicator(
            reservationDate = 13,
            availablePromotions = mutableListOf(DiscountPromotion.WEEKDAY_DISCOUNT_PROMOTION),
            orderedMenus = orderedMenu
        )

        val expectedDiscountAmount = 4046
        val christmasPromotionMap = promotionApplicator.applyPromotion()
        val actualDiscountAmount =
            christmasPromotionMap[DiscountPromotion.WEEKDAY_DISCOUNT_PROMOTION]

        assertEquals(expectedDiscountAmount, actualDiscountAmount)
    }

    @Test
    fun `주말 할인 적용 시 할인 금액이 올바르게 계산되는지 확인`() {
        val promotionApplicator = PromotionApplicator(
            reservationDate = 24,
            availablePromotions = mutableListOf(DiscountPromotion.CHRISTMAS_D_DAY_DISCOUNT_PROMOTION),
            orderedMenus = orderedMenu
        )

        val expectedDiscountAmount = 4046
        val christmasPromotionMap = promotionApplicator.applyPromotion()
        val actualDiscountAmount =
            christmasPromotionMap[DiscountPromotion.WEEKEND_DISCOUNT_PROMOTION]

        assertEquals(expectedDiscountAmount, actualDiscountAmount)
    }

    @Test
    fun `스폐셜 할인 적용 시 할인 금액이 올바르게 계산되는지 확인`() {
        val promotionApplicator = PromotionApplicator(
            reservationDate = 24,
            availablePromotions = mutableListOf(DiscountPromotion.SPECIAL_DISCOUNT_PROMOTION),
            orderedMenus = orderedMenu
        )

        val expectedDiscountAmount = 1000
        val christmasPromotionMap = promotionApplicator.applyPromotion()
        val actualDiscountAmount =
            christmasPromotionMap[DiscountPromotion.SPECIAL_DISCOUNT_PROMOTION]

        assertEquals(expectedDiscountAmount, actualDiscountAmount)
    }

    @Test
    fun `크리스마스 날 적용된 할인이 올바르게 계산되는지 확인`() {
        val promotionApplicator = PromotionApplicator(
            reservationDate = 25,
            availablePromotions = mutableListOf(
                DiscountPromotion.CHRISTMAS_D_DAY_DISCOUNT_PROMOTION,
                DiscountPromotion.SPECIAL_DISCOUNT_PROMOTION,
                DiscountPromotion.WEEKDAY_DISCOUNT_PROMOTION
            ),
            orderedMenus = orderedMenu
        )

        val expectedDiscountAmount = 8446
        val christmasPromotionMap = promotionApplicator.applyPromotion()
        val actualDiscountAmount = christmasPromotionMap.values.sum()
        assertEquals(expectedDiscountAmount, actualDiscountAmount)
    }
}
