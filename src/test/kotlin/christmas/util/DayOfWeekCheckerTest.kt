package christmas.util

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.DayOfWeek

class DayOfWeekCheckerTest {

    private val dayOfWeekChecker = DayOfWeekChecker()

    @Test
    fun `2023년 12월 15일 금요일 반환값 확인`() {
        val day = 15
        val expectedDayOfWeek = 5

        val result = dayOfWeekChecker.doDayOfWeek(day = day)

        assertEquals(expectedDayOfWeek, result)
    }

    @Test
    fun `2023년 12월 25일 월요일 반환값 확인`() {
        val day = 25
        val expectedDayOfWeek = 1

        val result = dayOfWeekChecker.doDayOfWeek(day = day)

        assertEquals(expectedDayOfWeek, result)
    }
}