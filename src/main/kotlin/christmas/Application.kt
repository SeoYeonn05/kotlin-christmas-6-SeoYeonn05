package christmas

import christmas.controller.ReceiptController
import christmas.model.order.OrderContent
import christmas.view.InputView
import christmas.view.OutputView

fun main() {
    val inputView = InputView.getInstance()

    val orderContent: OrderContent = inputView.reservationProcess()
    val receipt = ReceiptController(orderContent).getReceipt()

    OutputView(receipt).printReceipt()
}
