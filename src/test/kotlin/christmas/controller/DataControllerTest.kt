package christmas.controller

import christmas.controller.DateController
import christmas.exception.IllegalDateException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class DateControllerTest {

    @Test
    fun `valid date format returns correct date`() {
        val dateInput = "15" // Example valid input
        val dateController = DateController(dateInput)
        assertEquals(15, dateController.getData())
    }

    @Test
    fun `invalid date format throws IllegalDateException`() {
        val invalidDateInput = "abc" // Example invalid input
        assertThrows(IllegalDateException::class.java) {
            DateController(invalidDateInput)
        }
    }

    @Test
    fun `valid date range returns correct date`() {
        val dateInput = "25" // Example valid input within range
        val dateController = DateController(dateInput)
        assertEquals(25, dateController.getData())
    }

    @Test
    fun `invalid date range throws IllegalDateException`() {
        val invalidDateInput = "40" // Example input outside range
        assertThrows(IllegalDateException::class.java) {
            DateController(invalidDateInput)
        }
    }
}
