/*
package christmas.model

import christmas.constants.ErrorConstants
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PromotionDateTest {

    @Test
    fun `date 값으로 음수 입력`() {
        val exception =
            assertThrows<IllegalArgumentException> {
                PromotionDate("-1")
            }

        val expectedErrorMessage = "${ErrorConstants.ERROR_MESSAGE} ${ErrorConstants.INVALID_DATE_ERROR}"
        assertEquals(expectedErrorMessage, exception.message)


    }
    @Test
    fun `2023년 12월 3일 적용 이벤트 확인`() {
        val promotionDate = PromotionDate("3")

        val availablePromotions = promotionDate.getAvailablePromotions()

        assertEquals(3, promotionDate.getReservationDate())
        assertEquals(
            mutableListOf(
                DiscountPromotion.CHRISTMAS_D_DAY_DISCOUNT_PROMOTION,
                DiscountPromotion.WEEKDAY_DISCOUNT_PROMOTION,
                DiscountPromotion.SPECIAL_DISCOUNT_PROMOTION
            ),
            availablePromotions
        )
    }

    @Test
    fun `2023년 12월 30일 적용 이벤트 확인`() {
        val promotionDate = PromotionDate("30")

        val availablePromotions = promotionDate.getAvailablePromotions()

        assertEquals(30, promotionDate.getReservationDate())
        assertEquals(
            mutableListOf(
                DiscountPromotion.WEEKEND_DISCOUNT_PROMOTION,
            ),
            availablePromotions
        )
    }

    @Test
    fun `2023년 12월 25일 적용 이벤트 확인`() {
        val promotionDate = PromotionDate("25")

        val availablePromotions = promotionDate.getAvailablePromotions()

        assertEquals(25, promotionDate.getReservationDate())
        assertEquals(
            mutableListOf(
                DiscountPromotion.CHRISTMAS_D_DAY_DISCOUNT_PROMOTION,
                DiscountPromotion.WEEKDAY_DISCOUNT_PROMOTION,
                DiscountPromotion.SPECIAL_DISCOUNT_PROMOTION
            ),
            availablePromotions
        )
    }
}*/
