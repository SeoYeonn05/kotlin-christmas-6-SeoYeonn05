package christmas.model

import christmas.util.constant.ErrorConstants
import christmas.validation.exception.IllegalMenuException
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
    fun `존재하지 않는 orderMenus 입력`() {
        val exception =
            assertThrows<IllegalMenuException> {
                MenuManager("티본스테이크-1,바비큐립-1,똥-3")}

        val expectedErrorMessage = "${ErrorConstants.ERROR_MESSAGE} ${ErrorConstants.INVALID_MENU_ERROR}"
        Assertions.assertEquals(expectedErrorMessage, exception.message)
    }
}
