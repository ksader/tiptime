package com.example.tiptime

import org.junit.Test
import org.junit.Assert.*
import java.text.NumberFormat

class TipCalculatorTests {

    @Test
    fun calculateTip_20PercentNoRoundup() {
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        assertEquals(expectedTip, calculateTip(10.0, 20.0, false))
    }
}