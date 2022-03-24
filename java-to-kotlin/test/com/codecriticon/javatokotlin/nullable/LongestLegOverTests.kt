package com.codecriticon.javatokotlin.nullable

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.Duration
import java.util.*

public class LongestLegOverTests {

    private final List<Leg> legs = List.of(
    leg("one hour", Duration.ofHours(1)),
    leg("one day", Duration.ofDays(1)),
    leg("two hours", Duration.ofHours(2))
    );
    private final Duration oneDay = Duration.ofDays(1);

    @Test
    public void is_absent_when_no_legs()
    {
        assertEquals(
            Optional.empty(),
            findLongestLegOver(emptyList(), Duration.ZERO)
        );
    }

    @Test
    public void is_absent_when_no_legs_long_enough()
    {
        assertEquals(
            Optional.empty(),
            findLongestLegOver(legs, oneDay)
        );
    }

    @Test
    public void is_longest_leg_when_one_match()
    {
        assertEquals(
            "one day",
            findLongestLegOver(legs, oneDay.minusMillis(1))
                .orElseThrow().getDescription()
        );
    }

    @Test
    public void is_longest_leg_when_more_than_one_match()
    {
        assertEquals(
            "one day",
            findLongestLegOver(legs, Duration.ofMinutes(59))
                .orElseThrow().getDescription()
        );
    }

}
