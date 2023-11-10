package christmas.model

import christmas.util.Constants

enum class MenuCategory {
    APPETIZER,
    MAIN_COURSE,
    DESSERT,
    BEVERAGE
}

enum class Menu(
    private val menuName: String,
    private val menuPrice: Int,
    private val menuCategory: MenuCategory
) {
    MUSHROOM_SOUP(Constants.MUSHROOM_SOUP, 6000, MenuCategory.APPETIZER),
    TAPAS(Constants.TAPAS, 5500, MenuCategory.APPETIZER),
    CAESAR_SALAD(Constants.CAESAR_SALAD, 8000, MenuCategory.APPETIZER),
    T_BONE_STEAK(Constants.T_BONE_STEAK, 55000, MenuCategory.MAIN_COURSE),
    BBQ_RIBS(Constants.BBQ_RIBS, 54000, MenuCategory.MAIN_COURSE),
    SEAFOOD_PASTA(Constants.SEAFOOD_PASTA, 35000, MenuCategory.MAIN_COURSE),
    CHRISTMAS_PASTA(Constants.CHRISTMAS_PASTA, 25000, MenuCategory.MAIN_COURSE),
    CHOCOLATE_CAKE(Constants.CHOCOLATE_CAKE, 15000, MenuCategory.DESSERT),
    ICE_CREAM(Constants.ICE_CREAM, 5000, MenuCategory.DESSERT),
    ZERO_COLA(Constants.ZERO_COLA, 3000, MenuCategory.BEVERAGE),
    RED_WINE(Constants.RED_WINE, 60000, MenuCategory.BEVERAGE),
    CHAMPAGNE(Constants.CHAMPAGNE, 25000, MenuCategory.BEVERAGE);
}





