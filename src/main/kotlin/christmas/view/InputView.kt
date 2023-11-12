package christmas.view

import christmas.util.InputHandler
import christmas.util.constant.Constants
import christmas.validation.InputValidator

class InputView {
    private val print = Printer()
    private val inputProcessor = InputProcessor()

    fun printStartMessage(){
        print.printStartMessage()
    }
    fun requestReservationDate():String{
        print.printRequestReservationDateMessage()
        return inputProcessor.requestReservationDate()
    }
    fun requestReservationMenu(): String {
        print.printRequestReservationMenuMessage()
        return inputProcessor.requestReservationMenu()
    }
}