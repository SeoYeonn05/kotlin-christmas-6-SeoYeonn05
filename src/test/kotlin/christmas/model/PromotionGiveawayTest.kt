package christmas.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PromotionGiveawayTest {

    @Test
    fun `할인 전 총주문 금액이 12만원 이상일 때 샴페인 증정`(){
        var giveaway = PromotionGiveaway(120000).getGiveawayByAmount()

        var expectedGiveaway = GiveawayItem.CHAMPAGNE
        assertEquals(expectedGiveaway, giveaway)
    }

    @Test
    fun `할인 전 총주문 금액이 12만원 미만일 때 샴페인 증정`(){
        var giveaway = PromotionGiveaway(119000).getGiveawayByAmount()

        var expectedGiveaway = GiveawayItem.NO_GIVEAWAY
        assertEquals(expectedGiveaway, giveaway)
    }
}