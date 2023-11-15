package christmas.controller

import christmas.model.MenuItem
import christmas.model.MenuOrder
import christmas.validation.exception.IllegalMenuException
import christmas.view.InputView
import christmas.view.OutputView
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OrderDataControllerTest {
    @Test
    fun `올바른 사용자 값 입력`() {
        val mockInputView = mockk<InputView>()
        val orderDataController = OrderDataController(mockInputView)

        val fakeReservationDate = "25"
        val fakeReservationMenu = "티본스테이크-3,타파스-1"
        every { mockInputView.requestReservationDate() } returns fakeReservationDate
        every { mockInputView.requestReservationMenu() } returns fakeReservationMenu


        val orderDate = orderDataController.getOrderDate()
        val orderMenu = orderDataController.getOrderMenu()

        val expectedOrderData = mutableListOf(
            MenuOrder(MenuItem.T_BONE_STEAK, 3),
            MenuOrder(MenuItem.TAPAS, 1)
        )

        for (i in 0 until orderMenu.size) {
            assertEquals(expectedOrderData[i].getMenuItem(), orderMenu[i].getMenuItem())
        }
    }
/*    @Test
    fun `중복 메뉴 값 입력`() {
        val mockInputView = mockk<InputView>()
        val orderDataController = OrderDataController(mockInputView)

        val fakeReservationDate = "21"
        val fakeReservationMenu = "티본스테이크-3,타파스-1,타파스-1"
        every { mockInputView.requestReservationDate() } returns fakeReservationDate
        every { mockInputView.requestReservationMenu() } returns fakeReservationMenu

        val exception = assertThrows<IllegalMenuException> {
            orderDataController.getOrderMenu()
        }

        assertEquals("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.", exception)
    }*/
}