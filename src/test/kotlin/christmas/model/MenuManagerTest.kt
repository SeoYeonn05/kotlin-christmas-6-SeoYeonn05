/*
package christmas.model

import christmas.constants.ErrorConstants
import christmas.exception.IllegalMenuException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MenuManagerTest {
    @Test
    fun `MenuManager 클래스로 MenuOrder 리스트 생성`() {
        var orderedMenus = MenuManager("티본스테이크-1,바비큐립-1").getOrderedMenu()

        var expectedOrderedMenu = mutableListOf<MenuOrder>(
            MenuOrder(MenuItem.T_BONE_STEAK, 1),
            MenuOrder(MenuItem.BBQ_RIBS, 1),
        )

        for (i in 0 until orderedMenus.size) {
            Assertions.assertEquals(expectedOrderedMenu[i].getMenuItem(), orderedMenus[i].getMenuItem())
        }
    }

    @Test
    fun `존재하지 않는 orderMenus 입력 시 에러 처리`() {
        val exception =
            assertThrows<IllegalMenuException> {
                MenuManager("티본스테이크-1,바비큐립-1,똥-3, 바베큐립-1")}

        val expectedErrorMessage = "${ErrorConstants.ERROR_MESSAGE} ${ErrorConstants.INVALID_MENU_FORMAT_ERROR}"
        Assertions.assertEquals(expectedErrorMessage, exception.message)
    }

    @Test
    fun `음료만 주문 시 에러 처리`() {
        val exception =
            assertThrows<IllegalMenuException> {
                MenuManager("레드와인-1,샴페인-4")}

        val expectedErrorMessage = "${ErrorConstants.ERROR_MESSAGE} ${ErrorConstants.INVALID_MENU_FORMAT_ERROR}"
        Assertions.assertEquals(expectedErrorMessage, exception.message)
    }

    @Test
    fun `20개 이상의 메뉴 주문 시 에러 처리`() {
        val exception =
            assertThrows<IllegalMenuException> {
                MenuManager("해산물파스타-6,레드와인-15,샴페인-4")}

        val expectedErrorMessage = "${ErrorConstants.ERROR_MESSAGE} ${ErrorConstants.INVALID_MENU_FORMAT_ERROR}"
        Assertions.assertEquals(expectedErrorMessage, exception.message)
    }
}
*/
