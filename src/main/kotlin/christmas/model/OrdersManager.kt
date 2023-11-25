package christmas.model

import christmas.constants.MenuItem
import christmas.exception.IllegalMenuException
import christmas.util.DataFormatter


class OrdersManager {
    fun createOrderedMenu(splitOrder: List<String>): MutableList<Order> {
        var orders: MutableList<Order> = mutableListOf()

        splitOrder.forEach {
            orders.add(convertReservationMenu(it))
        }
        return orders
    }

    private fun convertReservationMenu(orderInput: String): Order {
        val splitByOrderAndCount = orderInput.split("-")
        val menu = MenuItem.stringToMenuItem(splitByOrderAndCount[0])
        var count = DataFormatter().stringToInt(splitByOrderAndCount[1])
        return Order(menu, count)
    }
}