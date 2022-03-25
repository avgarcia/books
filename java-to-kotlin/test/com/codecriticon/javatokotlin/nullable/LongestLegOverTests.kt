package com.codecriticon.javatokotlin.nullable

import com.codecriticon.javatokotlin.nullable.Legs.longestLegOver
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import java.time.Duration

class LongestLegOverTests {

    private val legs: List<Leg> = listOf(
        Leg("one hour", Duration.ofHours(1)),
        Leg("one day", Duration.ofDays(1)),
        Leg("two hours", Duration.ofHours(2))
    )

    private val oneDay: Duration = Duration.ofDays(1)

    @Test
    fun `is absent when no legs`() {
        assertNull(emptyList<Leg>().longestLegOver(Duration.ZERO))
    }

    @Test
    fun `is absent when no legs long enough`() {
        assertNull(legs.longestLegOver(oneDay))
    }

    @Test
    fun `is longest leg when one match`() {
        assertEquals(
            "one day",
            legs.longestLegOver(oneDay.minusMillis(1))?.description
        )
    }

    @Test
    fun `is longest leg when more than one match`() {
        assertEquals(
            "one day",
            legs.longestLegOver(Duration.ofMinutes(59))?.description
        )
    }

}
