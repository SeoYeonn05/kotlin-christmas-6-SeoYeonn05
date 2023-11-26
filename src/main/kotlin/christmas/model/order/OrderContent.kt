package christmas.model.order

import christmas.model.order.Order

data class OrderContent(
    val date: Int,
    val orders: MutableList<Order>
)