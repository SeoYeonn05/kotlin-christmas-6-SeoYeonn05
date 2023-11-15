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
        while (true) {
            val inputOrder: String = getReservationOrder()
            try {
                return createMenuOrder(inputOrder)
            } catch (e: IllegalMenuException) {
                println(e.message)
            }
        }
    }

    private fun getReservationDate(): String {
        return inputView.requestReservationDate()
    }

    private fun getReservationOrder(): String {
        return inputView.requestReservationMenu()
    }

    private fun createMenuOrder(inputOrder: String): MutableList<MenuOrder> {
        return try {
            return MenuManager(inputOrder).getOrderedMenu()
        } catch (e: IllegalMenuException) {
            print(e.message)
            mutableListOf()
        }
    }
}