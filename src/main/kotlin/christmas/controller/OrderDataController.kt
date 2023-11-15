package christmas.controller

import christmas.model.MenuManager
import christmas.model.MenuOrder
import christmas.validation.exception.IllegalDateException
import christmas.validation.exception.IllegalMenuException
import christmas.view.InputView

class OrderDataController(
    private val inputView: InputView
) {
    fun getOrderDate(): String {
        return getReservationDate()
    }
    fun getOrderMenu(): MutableList<MenuOrder> {
        val inputOrder: String = getReservationOrder()
        return createMenuOrder(inputOrder)
    }

    private fun getReservationDate(): String {
        return inputView.requestReservationDate()
    }

    private fun getReservationOrder(): String {
        return inputView.requestReservationMenu()
    }

    private fun createMenuOrder(inputOrder: String): MutableList<MenuOrder> {
        return MenuManager(inputOrder).getOrderedMenu()
    }
}