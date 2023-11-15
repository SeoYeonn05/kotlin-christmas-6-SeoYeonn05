package christmas.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MenuOrderTest {
    private val noMenu = MenuOrder(MenuItem.NO_MENU, 3)
    private val bbqExtraCount = MenuOrder(MenuItem.BBQ_RIBS, 21)
    private val bbqZeroCount = MenuOrder(MenuItem.BBQ_RIBS, 0)
    private val bbq = MenuOrder(MenuItem.BBQ_RIBS, 3)
    private val tBone = MenuOrder(MenuItem.T_BONE_STEAK, 2)
    val chocoCake = MenuOrder(MenuItem.CHOCOLATE_CAKE, 21)
    val zeroCola = MenuOrder(MenuItem.ZERO_COLA, 2)


    @Test
    fun `올바른 메뉴 입력`() {
        assertTrue(tBone.validateOrderMenu())
    }

    @Test
    fun `NoMenu 입력`() {
        assertFalse(noMenu.validateOrderMenu())
    }

    @Test
    fun `1개 이상 20개 이하의 음식 주문`() {
        assertTrue(bbq.validateMenuCountRange())
    }

    @Test
    fun `20개 초과 음식 주문`() {
        assertFalse(bbqExtraCount.validateMenuCountRange())
    }

    @Test
    fun `1개 미만의 음식 주문`() {
        assertFalse(bbqZeroCount.validateMenuCountRange())
    }

    @Test
    fun `메뉴 개수의 합 계산`() {
        val totalMenuCount = 15
        assertEquals(17, tBone.sumMenuCount(totalMenuCount))
    }

    @Test
    fun `주문한 메뉴 가격 계산`() {
        assertEquals(110000, tBone.calculateMenuAmount())
    }

    @Test
    fun `메뉴가 음료수인지 확인`() {
        assertTrue(zeroCola.validateIsBeverage())
    }

    @Test
    fun `메뉴가 음료수가 아닐 경우`() {
        assertFalse(chocoCake.validateIsBeverage())
    }
}
