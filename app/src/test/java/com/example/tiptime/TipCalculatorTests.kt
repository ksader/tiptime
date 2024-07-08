package com.example.tiptime

import org.junit.Test
import org.junit.Assert.*
import java.text.NumberFormat

class TipCalculatorTests {

    @Test
    fun calculateTip_20PercentNoRoundup() {
        val expectedTip = 2.0
        assertEquals(expectedTip, calculateTip(10.0, 20.0, false), 0.001)
    }

    @Test
    fun calculateTip_21PercentRoundup() {
        val expectedTip = 29.43
        assertEquals(expectedTip, calculateTip(126.57, 22.58, true), 0.001)
    }

    @Test
    fun calculateTotal() {
        val totalBill = 12.2
        assertEquals(totalBill, calculateTotalBill(10.0, 2.2, false), 0.001)
    }

    @Test
    fun calculateTotal_RoundUpToWholeDollar() {
        val totalBill = 156.00
        assertEquals(totalBill, calculateTotalBill(126.57, 29.43, false), 0.001)
    }
}