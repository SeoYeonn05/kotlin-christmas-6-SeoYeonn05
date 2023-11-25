package christmas.model

data class OrderContent(
    val date: Int,
    val orders: MutableList<Order>
)