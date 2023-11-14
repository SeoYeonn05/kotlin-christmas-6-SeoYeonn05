package christmas.model

import christmas.util.constant.ErrorConstants
import christmas.util.constant.MenuConstants

enum class MenuCategory {
    APPETIZER,
    MAIN,
    DESSERT,
    BEVERAGE,
    ELSE
}

enum class MenuItem(
    private val menuName: String,
    private val menuPrice: Int,
    private val menuCategory: MenuCategory
) {
    MUSHROOM_SOUP(MenuConstants.MUSHROOM_SOUP, 6000, MenuCategory.APPETIZER),
    TAPAS(MenuConstants.TAPAS, 5500, MenuCategory.APPETIZER),
    CAESAR_SALAD(MenuConstants.CAESAR_SALAD, 8000, MenuCategory.APPETIZER),
    T_BONE_STEAK(MenuConstants.T_BONE_STEAK, 55000, MenuCategory.MAIN),
    BBQ_RIBS(MenuConstants.BBQ_RIBS, 54000, MenuCategory.MAIN),
    SEAFOOD_PASTA(MenuConstants.SEAFOOD_PASTA, 35000, MenuCategory.MAIN),
    CHRISTMAS_PASTA(MenuConstants.CHRISTMAS_PASTA, 25000, MenuCategory.MAIN),
    CHOCOLATE_CAKE(MenuConstants.CHOCOLATE_CAKE, 15000, MenuCategory.DESSERT),
    ICE_CREAM(MenuConstants.ICE_CREAM, 5000, MenuCategory.DESSERT),
    ZERO_COLA(MenuConstants.ZERO_COLA, 3000, MenuCategory.BEVERAGE),
    RED_WINE(MenuConstants.RED_WINE, 60000, MenuCategory.BEVERAGE),
    CHAMPAGNE(MenuConstants.CHAMPAGNE, 25000, MenuCategory.BEVERAGE),
    NO_MENU(ErrorConstants.ERROR_MESSAGE, 0, MenuCategory.ELSE);

    fun getMenuPrice() = this.menuPrice
    fun getMenuCategory() = this.menuCategory

    companion object {
        fun isMenuAvailable(menuName: String): MenuItem {
            return values().find { it.menuName == menuName } ?: NO_MENU
        }
    }
}




