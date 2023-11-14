package christmas.model

import christmas.validation.exception.IllegalPromotionException

class PromotionApplicator(
    private val availablePromotions: MutableList<DiscountPromotion>,
    private val orderedMenus: MutableList<MenuOrder>,
) {
    lateinit var promotionalPrice: MutableMap<DiscountPromotion, Int>
    private val discountCalculator = DiscountCalculator()

    fun applyWeekPromotion(): MutableMap<DiscountPromotion, Int> {
        availablePromotions.forEach {
            when (it) {
                DiscountPromotion.CHRISTMAS_D_DAY_DISCOUNT_PROMOTION -> {}
                DiscountPromotion.WEEKDAY_DISCOUNT_PROMOTION -> applyWeekDayPromotion(it)
                DiscountPromotion.WEEKEND_DISCOUNT_PROMOTION -> applyWeekendPromotion(it)
                DiscountPromotion.SPECIAL_DISCOUNT_PROMOTION -> {}
                else -> IllegalPromotionException.invalidPromotion
            }
        }
        return promotionalPrice
    }

    private fun applyWeekDayPromotion(promotion: DiscountPromotion) {
        var discountAmount = 0
        var validCategoryMenu = orderedMenus.filter { menuOrder ->
            menuOrder.getMenuItem().getMenuCategory() == weekdayPromotionApplyMenu
        }
        validCategoryMenu.forEach {
            discountAmount = discountCalculator.calculateDiscountAmount(promotion, it)
        }
        availablePromotions[discountAmount] = promotion
    }

    private fun applyWeekendPromotion(promotion: DiscountPromotion) {
        var discountAmount = 0
        var validCategoryMenu = orderedMenus.filter { menuOrder ->
            menuOrder.getMenuItem().getMenuCategory() == weekendPromotionApplyMenu
        }
        validCategoryMenu.forEach {
            discountAmount = discountCalculator.calculateDiscountAmount(promotion, it)
        }
        availablePromotions[discountAmount] = promotion
    }

    companion object {
        val weekdayPromotionApplyMenu = MenuCategory.DESSERT
        val weekendPromotionApplyMenu = MenuCategory.MAIN
    }
}