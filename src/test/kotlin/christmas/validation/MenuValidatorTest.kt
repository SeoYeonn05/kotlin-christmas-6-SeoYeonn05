/*
package christmas.validation

import christmas.constants.MenuItem
import christmas.model.order.Order
import christmas.constants.ErrorConstants
import christmas.exception.IllegalMenuException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MenuInvalidatorTest {

    private val seafoodPasta = Order(MenuItem.SEAFOOD_PASTA, 2)
    private val iceCream = Order(MenuItem.ICE_CREAM, 1)
    private val bbqRibs = Order(MenuItem.BBQ_RIBS, 5)

    // 존재하는 메뉴인지 확인
    // 주문한 메뉴 개수 확인

    @Test
    fun `정상적인 메뉴 입력`() {
        val menu1 = seafoodPasta
        val menu2 = iceCream
        val menu3 = bbqRibs

        val menuOrders = listOf(menu1, menu2, menu3)
        assertDoesNotThrow {
            MenuInvalidator().validateMenuItem(menuOrders)
        }
    }

    @Test
    fun `중복된 메뉴 입력 시 예외 처리 확인`() {
        val menu1 = seafoodPasta
        val menu2 = iceCream
        val menu3 = seafoodPasta

        val menuOrders = listOf(menu1, menu2, menu3)

        val exception =
            assertThrows<IllegalMenuException> {
                MenuInvalidator().validateMenuItem(menuOrders)
            }
        val expectedErrorMessage = "${ErrorConstants.ERROR_MESSAGE} ${ErrorConstants.INVALID_MENU_FORMAT_ERROR}"
        Assertions.assertEquals(expectedErrorMessage, exception.message)
    }

    @Test
    fun `존재하지 않는 메뉴 입력 시 예외처리`() {
        val menu1 = seafoodPasta
        val menu2 = iceCream
        val menu3 = seafoodPasta
        val menu4 = Order(MenuItem.NO_MENU, 3)

        val menuOrders = listOf(menu1, menu2, menu3, menu4)
        val exception =
            assertThrows<IllegalMenuException> {
                MenuInvalidator().validateMenuItem(menuOrders)
            }

        val expectedErrorMessage = "${ErrorConstants.ERROR_MESSAGE} ${ErrorConstants.INVALID_MENU_FORMAT_ERROR}"
        Assertions.assertEquals(expectedErrorMessage, exception.message)
    }

    @Test
    fun `주문한 메뉴 개수가 양의 정수가 아닌 경우`() {
        val menu1 = seafoodPasta
        val menu2 = iceCream
        val menu3 = Order(MenuItem.BBQ_RIBS, -1)

        val menuOrders = listOf(menu1, menu2, menu3)
        val exception =
            assertThrows<IllegalMenuException> {
                MenuInvalidator().validateMenuItem(menuOrders)
            }

        val expectedErrorMessage = "${ErrorConstants.ERROR_MESSAGE} ${ErrorConstants.INVALID_MENU_FORMAT_ERROR}"
        Assertions.assertEquals(expectedErrorMessage, exception.message)
    }
}
*/
