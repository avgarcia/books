package com.codecriticon.javatokotlin.nullable

import java.time.Duration
import java.util.*


object Legs {

    @JvmStatic
    fun findLongestLegOver(
        legs: List<Leg>,
        duration: Duration
    ): Optional<Leg> {
        return Optional.ofNullable(legs.longestLegOver(duration))
    }

    fun List<Leg>.longestLegOver(duration: Duration): Leg? =
        maxByOrNull {
            it.plannedDuration
        }?.takeIf { longestLeg ->
            longestLeg.isLongerThan(duration)
        }


    private fun Leg.isLongerThan(duration: Duration) = plannedDuration > duration

}
