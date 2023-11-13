package christmas.model

enum class GiveawayItem(
    private val amount: Int
) {
    CHAMPAGNE(120000),
    NO_GIVEAWAY(0);

    companion object {
        fun getGiveawayByAmount(amount: Int): GiveawayItem {
            return when {
                amount >= CHAMPAGNE.amount -> CHAMPAGNE
                else -> NO_GIVEAWAY
            }
        }
    }
}

class PromotionGiveaway(private val amount: Int) {
    fun getGiveawayByAmount(): GiveawayItem {
        return GiveawayItem.getGiveawayByAmount(amount)
    }
}