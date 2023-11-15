package christmas.model

class PromotionApplicator(
    private val reservationDate: Int,
    private val availablePromotions: MutableList<DiscountPromotion>,
    private val orderedMenus: MutableList<MenuOrder>,
) {
    private var promotionalPrice: MutableMap<DiscountPromotion, Int> = mutableMapOf()
    private val discountCalculator = DiscountCalculator()

    fun applyPromotion(): MutableMap<DiscountPromotion, Int> {
        availablePromotions.forEach {
            when (it) {
                DiscountPromotion.CHRISTMAS_D_DAY_DISCOUNT_PROMOTION -> applyChristmasDDayPromotion(it)
                DiscountPromotion.WEEKDAY_DISCOUNT_PROMOTION -> applyWeekDayPromotion(it)
                DiscountPromotion.WEEKEND_DISCOUNT_PROMOTION -> applyWeekendPromotion(it)
                DiscountPromotion.SPECIAL_DISCOUNT_PROMOTION -> applySpecialPromotion(it)
                DiscountPromotion.NO_PROMOTION -> mutableMapOf(DiscountPromotion.NO_PROMOTION to 0)
            }
        }
        return promotionalPrice
    }
    private fun applyChristmasDDayPromotion(promotion: DiscountPromotion){
        var discountAmount = 1000 + (promotion.getDiscountAmount() * (reservationDate - 1))
        if (reservationDate> christmasDDay){
            discountAmount = 0
        }
        promotionalPrice[promotion] = discountAmount
    }

    private fun applyWeekDayPromotion(promotion: DiscountPromotion) {
        var discountAmount = 0
        var validCategoryMenu = orderedMenus.filter { menuOrder ->
            menuOrder.getMenuItem().getMenuCategory() == weekdayPromotionApplyMenu
        }
        validCategoryMenu.forEach {
            discountAmount = discountCalculator.calculateDiscountAmount(promotion, it)
        }
        promotionalPrice[promotion] = discountAmount    }

    private fun applyWeekendPromotion(promotion: DiscountPromotion) {
        var discountAmount = 0
        var validCategoryMenu = orderedMenus.filter { menuOrder ->
            menuOrder.getMenuItem().getMenuCategory() == weekendPromotionApplyMenu
        }
        validCategoryMenu.forEach {
            discountAmount = discountCalculator.calculateDiscountAmount(promotion, it)
        }
        promotionalPrice[promotion] = discountAmount
    }
    private fun applySpecialPromotion(promotion: DiscountPromotion) {
        var discountAmount = specialPromotionDiscount
        promotionalPrice[promotion] = discountAmount
    }
    companion object {
        const val specialPromotionDiscount = 1000
        const val christmasDDay = 25
        val weekdayPromotionApplyMenu = MenuCategory.DESSERT
        val weekendPromotionApplyMenu = MenuCategory.MAIN
    }
}