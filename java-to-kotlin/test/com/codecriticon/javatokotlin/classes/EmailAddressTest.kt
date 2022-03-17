package com.codecriticon.javatokotlin.classes

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EmailAddressTest {

    @Test
    fun parsing() {
        assertEquals(
            EmailAddress("fred", "example.com"),
            EmailAddress.parse("fred@example.com")
        )
    }

    @Test
    fun parsingFailures() {
        assertThrows(IllegalArgumentException::class.java
        ) { EmailAddress.parse("@") }
    }

}
