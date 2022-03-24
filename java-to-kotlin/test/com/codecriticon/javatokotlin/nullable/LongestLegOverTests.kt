package com.codecriticon.javatokotlin.nullable

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
        assertNull(Legs.longestLegOver(emptyList(), Duration.ZERO))
    }

    @Test
    fun `is absent when no legs long enough`() {
        assertNull(Legs.longestLegOver(legs, oneDay))
    }

    @Test
    fun `is longest leg when one match`() {
        assertEquals(
            "one day",
            Legs.longestLegOver(legs, oneDay.minusMillis(1))?.description
        )
    }

    @Test
    fun `is longest leg when more than one match`() {
        assertEquals(
            "one day",
            Legs.longestLegOver(legs, Duration.ofMinutes(59))?.description
        )
    }

}
