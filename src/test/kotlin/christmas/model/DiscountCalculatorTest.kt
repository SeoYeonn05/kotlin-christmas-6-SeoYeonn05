package christmas.model

import christmas.util.constant.ErrorConstants
import christmas.validation.exception.IllegalPromotionException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class DiscountCalculatorTest {

/*    @Test
    fun `메인 메뉴 주문 시 평일 할인 적용`() {
        val discountCalculator = DiscountCalculator()
        val availablePromotion = DiscountPromotion.WEEKDAY_DISCOUNT_PROMOTION
        val orderedMenu = MAIN_MENU_ORDER_3

        val discountAmount =
            discountCalculator.calculateDiscountAmount(availablePromotion, orderedMenu)

        val expectedDiscountAmount = NO_DISCOUNT_ACCONT
        assertEquals(expectedDiscountAmount, discountAmount)
    }

    @Test
    fun `메인 메뉴 주문 시 주말 할인 적용`() {
        val discountCalculator = DiscountCalculator()
        val availablePromotion = DiscountPromotion.WEEKEND_DISCOUNT_PROMOTION
        val orderedMenu = MAIN_MENU_ORDER_3

        val discountAmount =
            discountCalculator.calculateDiscountAmount(availablePromotion, orderedMenu)

        val expectedDiscountAmount = EXPECTED_DISCOUNT_ACCOUNT * 3
        assertEquals(expectedDiscountAmount, discountAmount)
    }

    @Test
    fun `디저트 메뉴 주문 시 평일 할인 적용`() {
        val discountCalculator = DiscountCalculator()
        val availablePromotion = DiscountPromotion.WEEKDAY_DISCOUNT_PROMOTION
        val orderedMenu = DESSERT_MENU_ORDER_2

        val discountAmount =
            discountCalculator.calculateDiscountAmount(availablePromotion, orderedMenu)

        val expectedDiscountAmount = EXPECTED_DISCOUNT_ACCOUNT * 2
        assertEquals(expectedDiscountAmount, discountAmount)
    }

    @Test
    fun `디저트 메뉴 주문 시 주말 할인 적용`() {
        val discountCalculator = DiscountCalculator()
        val availablePromotion = DiscountPromotion.WEEKEND_DISCOUNT_PROMOTION
        val orderedMenu = DESSERT_MENU_ORDER_2

        val discountAmount =
            discountCalculator.calculateDiscountAmount(availablePromotion, orderedMenu)

        val expectedDiscountAmount = NO_DISCOUNT_ACCONT
        assertEquals(expectedDiscountAmount, discountAmount)
    }

    @Test
    fun `디저트 메뉴 0개 주문 시 평일 할인 적용`() {
        val discountCalculator = DiscountCalculator()
        val availablePromotion = DiscountPromotion.WEEKDAY_DISCOUNT_PROMOTION
        val orderedMenu = DESSERT_MENU_ORDER_0

        val discountAmount =
            discountCalculator.calculateDiscountAmount(availablePromotion, orderedMenu)

        val expectedDiscountAmount = NO_DISCOUNT_ACCONT
        assertEquals(expectedDiscountAmount, discountAmount)
    }*/

    @Test
    fun `메뉴 주문 시 주말 할인 적용`() {
        val discountCalculator = DiscountCalculator()
        val availablePromotion = DiscountPromotion.WEEKDAY_DISCOUNT_PROMOTION
        val orderedMenu = APPETIZER_MENU_ORDER_3

        val discountAmount =
            discountCalculator.calculateDiscountAmount(availablePromotion, orderedMenu)

        val expectedDiscountAmount = EXPECTED_DISCOUNT_ACCOUNT * 3
        assertEquals(expectedDiscountAmount, discountAmount)
    }

    @Test
    fun `메뉴 주문 시 평일 할인 적용`() {
        val discountCalculator = DiscountCalculator()
        val availablePromotion = DiscountPromotion.WEEKDAY_DISCOUNT_PROMOTION
        val orderedMenu = APPETIZER_MENU_ORDER_3

        val discountAmount =
            discountCalculator.calculateDiscountAmount(availablePromotion, orderedMenu)

        val expectedDiscountAmount = EXPECTED_DISCOUNT_ACCOUNT * 3
        assertEquals(expectedDiscountAmount, discountAmount)
    }

    @Test
    fun `메뉴 주문 시 크리스마스 할인 적용 Exception`() {
        val discountCalculator = DiscountCalculator()
        val availablePromotion = DiscountPromotion.CHRISTMAS_D_DAY_DISCOUNT_PROMOTION
        val orderedMenu = DESSERT_MENU_ORDER_2

        val exception =
            assertThrows<IllegalPromotionException> {
                discountCalculator.calculateDiscountAmount(availablePromotion, orderedMenu)
            }

        val expectedErrorMessage = "${ErrorConstants.ERROR_MESSAGE} ${ErrorConstants.INVALID_PROMOTION_ERROR}"
        assertEquals(expectedErrorMessage, exception.message)
    }
    companion object {
        private val EXPECTED_DISCOUNT_ACCOUNT = 2023
        private val NO_DISCOUNT_ACCONT = 0
        private val APPETIZER_MENU_ORDER_3 = MenuOrder(
            menuItem = MenuItem.CAESAR_SALAD,
            orderedMenuCount = 3
        )
        private val APPETIZER_MENU_ACCOUNT = 24000
        private val MAIN_MENU_ORDER_3 = MenuOrder(
            menuItem = MenuItem.T_BONE_STEAK,
            orderedMenuCount = 3
        )
        private val MAIN_MENU_ACCOUNT = 165000
        private val MAIN_MENU_DISCOUNT_ACCOUNT = 158931
        private val DESSERT_MENU_ORDER_2 = MenuOrder(
            menuItem = MenuItem.CHOCOLATE_CAKE,
            orderedMenuCount = 2
        )
        private val DESSERT_MENU_ACCOUNT = 30000
        private val DESSERT_MENU_DISCOUNT_ACCOUNT = 25954

        private val DESSERT_MENU_ORDER_0 = MenuOrder(
            menuItem = MenuItem.CHOCOLATE_CAKE,
            orderedMenuCount = 0
        )
    }
}
