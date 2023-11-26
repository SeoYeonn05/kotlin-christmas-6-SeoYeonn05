package christmas.model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PromotionBadgeTest {
    @Test
    fun `배지가 부여되지 않는 금액 확인`(){
        val totalBenefitAmount = 3000
        val actualBadge = PromotionBadge(totalBenefitAmount).givePromotionBadge()
        val expectedBadge = Badge.NO_BADGE

        Assertions.assertEquals(expectedBadge, actualBadge)
    }
    @Test
    fun `금액에 따른 별 배지 부여 확인`(){
        val totalBenefitAmount = 7000
        val actualBadge = PromotionBadge(totalBenefitAmount).givePromotionBadge()
        val expectedBadge = Badge.STAR

        Assertions.assertEquals(expectedBadge, actualBadge)
    }
    @Test
    fun `금액에 따른 트리 배지 부여 확인`(){
        val totalBenefitAmount = 19900
        val actualBadge = PromotionBadge(totalBenefitAmount).givePromotionBadge()
        val expectedBadge = Badge.TREE

        Assertions.assertEquals(expectedBadge, actualBadge)
    }
    @Test
    fun `금액에 따른 산타 배지 부여 확인`(){
        val totalBenefitAmount = 23000
        val actualBadge = PromotionBadge(totalBenefitAmount).givePromotionBadge()
        val expectedBadge = Badge.SANTA

        Assertions.assertEquals(expectedBadge, actualBadge)
    }
}

