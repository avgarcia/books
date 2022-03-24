package com.codecriticon.javatokotlin.nullable

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.Duration
import java.util.*

class LongestLegOverTests {

    private val legs: List<Leg> = listOf(
        Leg("one hour", Duration.ofHours(1)),
        Leg("one day", Duration.ofDays(1)),
        Leg("two hours", Duration.ofHours(2))
    )

    private val oneDay: Duration = Duration.ofDays(1)

    @Test
    fun is_absent_when_no_legs() {
        assertEquals(
            Optional.empty<Any>(),
            Legs.findLongestLegOver(emptyList(), Duration.ZERO)
        )
    }

    @Test
    fun is_absent_when_no_legs_long_enough() {
        assertEquals(
            Optional.empty<Any>(),
            Legs.findLongestLegOver(legs, oneDay)
        )
    }

    @Test
    fun is_longest_leg_when_one_match() {
        assertEquals(
            "one day",
            Legs.findLongestLegOver(legs, oneDay.minusMillis(1))
                .orElseThrow().description
        )
    }

    @Test
    fun is_longest_leg_when_more_than_one_match() {
        assertEquals(
            "one day",
            Legs.findLongestLegOver(legs, Duration.ofMinutes(59))
                .orElseThrow().description
        )
    }

}
