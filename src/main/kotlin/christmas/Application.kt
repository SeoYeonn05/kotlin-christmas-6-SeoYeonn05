package christmas

import christmas.controller.PromotionController
import christmas.view.InputView
import christmas.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    PromotionController(inputView, outputView).run()
}
