package christmas

import christmas.controller.PromotionController
import christmas.model.OrderContent
import christmas.view.InputView
import christmas.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    val orderContent: OrderContent = inputView.reservationProcess()
    PromotionController(orderContent).run()
}
