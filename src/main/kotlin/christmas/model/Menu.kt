package christmas.model

class MenuOrder(private val menuItem: MenuItem, private val orderedMenuCount: Int) {
    fun validateOrderMenu(): Boolean {
        return menuItem != MenuItem.NO_MENU
    }

    fun validateMenuCountRange(): Boolean {
        return orderedMenuCount >= MIN_MENU_COUNT
    }

    fun sumMenuCount(totalMenuCount: Int): Int {
        return totalMenuCount + orderedMenuCount
    }

    companion object {
        private const val MIN_MENU_COUNT = 1
        private const val MAX_MENU_COUNT = 20
    }
}