package christmas.controller

import christmas.exception.IllegalMenuException
import christmas.model.Order
import christmas.model.OrdersManager

class OrdersController(
    private val ordersInput: String
) {
    private val ordersManager: OrdersManager = OrdersManager()
    private lateinit var orders: MutableList<Order>

    init {
        val splitByOrders = splitOrders(ordersInput)
        if (!validOrderFormat(splitByOrders)) {
            throw IllegalMenuException.invalidMenuFormat
        }
        orders = createOrders(splitByOrders)
        if (!validOrderLogic(orders)) {
            throw IllegalMenuException.invalidMenuItem
        }
    }

    fun getOrders() = orders

    // private 함수에서 필요한 값이 있을 때 MenuController의 생성자를 바로 가져와서 사용할까? 아니면 아래 처럼 매개변수를 입력받아서 init에서 가져오게 할까?
    // 매개변수를 입력받아서 하니 매개변수 값의 이름이나 형식 등이 바뀌면 하나하나 다 바꿔줘야 되는 불편함 발생
    fun createOrders(splitByOrders: List<String>): MutableList<Order> {
        return ordersManager.createOrderedMenu(splitByOrders)
    }

    private fun splitOrders(ordersInput: String) = ordersInput.split(",")

    private fun validOrderFormat(splitByOrders: List<String>): Boolean {
        val regex = Regex("^[가-힣A-Za-z]+-\\d+\$")
        splitByOrders.forEach { orderInput ->
            if (!orderInput.matches(regex)) {
                return false
            }
        }
        return true
    }

    private fun validOrderLogic(orders: List<Order>): Boolean {
        return isValidOrderCountRange(orders) &&
                isNotBeverageOnlyOrder(orders) &&
                isValidMaximumOrderCount(orders) &&
                isValidMenu(orders) &&
                isNotDuplicatedMenu(orders)
    }

    // order의 menuCount를 get으로 가져와서 validate 해야될까? 아니면 menuCount를 public으로 만들어서 바로 가져와서 validate 해야될까?
    fun isValidOrderCountRange(orders: List<Order>): Boolean {
        return orders.all { order ->
            order.getCount() in MIN_MENU_COUNT..MAX_MENU_COUNT
        }
    }

    private fun isNotBeverageOnlyOrder(orders: List<Order>): Boolean {
        var beverageMenus = orders.filter { menuOrder ->
            menuOrder.checkBeverage()
        }
        return beverageMenus.size != orders.size
    }

    private fun isValidMaximumOrderCount(orders: List<Order>): Boolean {
        var totalMenuCount = 0
        orders.forEach { order ->
            totalMenuCount += order.getCount()
        }
        return totalMenuCount <= MAX_MENU_COUNT
    }


    private fun isNotDuplicatedMenu(orders: List<Order>): Boolean {
        val distinctMenuItems = orders.distinctBy { it.getMenu() }
        return distinctMenuItems.size == orders.size
    }


    private fun isValidMenu(orders: List<Order>): Boolean {
        return orders.all { it.validateOrderMenu() }
    }

    companion object {
        private const val MIN_MENU_COUNT = 1
        private const val MAX_MENU_COUNT = 20
    }
}
