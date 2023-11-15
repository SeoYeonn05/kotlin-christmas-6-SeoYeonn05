package christmas.model

import christmas.util.DataFormatter
import christmas.validation.MenuInvalidator
import christmas.validation.exception.IllegalMenuException
import kotlin.io.path.createTempDirectory

class MenuManager(private val inputReservationMenu: String) {
    private var orderedMenus: MutableList<MenuOrder> = mutableListOf()

    init {
        try{
            createOrderedMenu()
            MenuInvalidator().validateMenuItem(orderedMenus)
            checkOrderMenuConditions()
        }
        catch(e: Exception){
            throw e
        }
    }

    fun getOrderedMenu() = orderedMenus

    private fun checkOrderMenuConditions(){
        checkBeverageOnlyOrder()
        checkMaximumMenuCount()
    }
    private fun checkBeverageOnlyOrder() {
        var beverageMenus = orderedMenus.filter { menuOrder ->
            menuOrder.validateIsBeverage()
        }
        if(beverageMenus.size == orderedMenus.size){
            throw IllegalMenuException.onlyBeverageOrder
        }
    }

    private fun checkMaximumMenuCount() {
        var totalMenuCount = 0
        orderedMenus.forEach { menuOrder ->
            totalMenuCount = menuOrder.sumMenuCount(totalMenuCount)
        }
        if (totalMenuCount > MAX_TOTAL_MENU_COUNT){
            throw IllegalMenuException.maximumOrderCount
        }
    }

    private fun createOrderedMenu() {
        val reservationMenu = inputReservationMenu.split(",")
        reservationMenu.forEach { menuStr: String ->
            orderedMenus.add(convertReservationMenu(menuStr))
        }
    }

    private fun convertReservationMenu(menuStr: String): MenuOrder {
        val splitMenuString = menuStr.split("-")
        val menuName = MenuItem.isMenuAvailable(splitMenuString[0])
        val menuCount = DataFormatter().parseToIntMenuCount(splitMenuString[1])

        return MenuOrder(menuName, menuCount)
    }
    companion object{
        private const val MAX_TOTAL_MENU_COUNT = 20
    }
}