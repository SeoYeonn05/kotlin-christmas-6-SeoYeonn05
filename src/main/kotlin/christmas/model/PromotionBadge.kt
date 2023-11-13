package christmas.model

enum class Badge(
    private val badge: String,
    private val minimumBadgeAmount: Int
) {
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000),
    NO_BADGE("없음", 0);

    companion object{
        fun checkRangeOfBadge(totalBenefitAmount: Int): Badge {
            return when {
                totalBenefitAmount >= SANTA.minimumBadgeAmount -> SANTA
                totalBenefitAmount >= TREE.minimumBadgeAmount -> TREE
                totalBenefitAmount >= STAR.minimumBadgeAmount -> STAR
                else -> NO_BADGE
            }
        }
    }
}


class PromotionBadge(private val totalBenefitAmount: Int) {
    fun givePromotionBadge(): Badge {
        return Badge.checkRangeOfBadge(totalBenefitAmount)
    }
}