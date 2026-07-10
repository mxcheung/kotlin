package com.example.inventory

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File

class TestTask4_2 {

    @Test
    fun testNoVarStatusAssignment() {
        val source = File("src/main/kotlin/com/example/inventory/InventoryService.kt").readText()
        assertFalse(
            source.contains("var status"),
            "InventoryService.kt should not assign 'status' to a var — use val with a when expression"
        )
    }

    @Test
    fun testUsesWhenExpression() {
        val source = File("src/main/kotlin/com/example/inventory/InventoryService.kt").readText()
        assertTrue(
            source.contains("val status") && source.contains("when {"),
            "InventoryService.kt should assign 'status' using a val with a when expression"
        )
    }
}
