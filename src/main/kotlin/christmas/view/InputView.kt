package christmas.view

import christmas.constants.ErrorConstants
import christmas.controller.DateController
import christmas.controller.OrdersController
import christmas.exception.IllegalDateException
import christmas.exception.IllegalMenuException
import christmas.model.order.Order
import christmas.model.order.OrderContent
import christmas.util.InputHandler

class InputView {
    private val print = Printer()
    private val inputHandler = InputHandler()
    private val errorConstants = ErrorConstants

    fun reservationProcess(): OrderContent {
        printStartMessage()
        val date = requestReservationDate()
        val orders = requestReservationOrder()
        return OrderContent(date, orders)
    }

    private fun printStartMessage() {
        print.printStartMessage()
    }

    private fun requestReservationDate(): Int {
        print.printRequestReservationDateMessage()

        while (true) {
            try {
                val inputDate = inputHandler.inputHandler()
                return DateController(inputDate).getData()
            } catch (e: IllegalDateException) {
                println("${e.message}")
            }
        }
    }

    private fun requestReservationOrder(): MutableList<Order> {
        print.printRequestReservationMenuMessage()
        while (true) {
            try {
                val inputOrder = inputHandler.inputHandler()
                return OrdersController(inputOrder).getOrders()
            } catch (e: IllegalMenuException) {
                println("${e.message}")
            }
        }
    }

    companion object {
        @Volatile
        private var instance: InputView? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: InputView().also { instance = it }
            }
    }
}