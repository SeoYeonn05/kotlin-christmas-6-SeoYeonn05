package christmas.model

enum class GiveawayItem(
    private val giveaway: String,
    private val amount: Int,
    private val giveawayAmount: Int
) {
    CHAMPAGNE("샴페인", 120000, 25000),
    NO_GIVEAWAY("없음",0, 0);

    fun getGiveaway() = this.giveaway
    fun applyGiveawayAMount(amount: Int):Int{
        return amount - this.giveawayAmount
    }
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