package christmas.model

class MenuOrder(private val menuItem: MenuItem, private val orderedMenuCount: Int) {
    init {
        //예외처리
    }

    fun validateOrderMenu(): Boolean {
        return menuItem != MenuItem.NO_MENU
    }

    fun validateMenuRange(): Boolean {
        return orderedMenuCount >= MIN_MENU_COUNT
    }

    companion object {
        private const val MIN_MENU_COUNT = 1
        private const val MAX_MENU_COUNT = 20
    }
}