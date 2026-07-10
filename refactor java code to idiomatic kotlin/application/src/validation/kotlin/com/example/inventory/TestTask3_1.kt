package com.example.inventory

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File

class TestTask3_1 {

    @Test
    fun testNoExplicitNullGuard() {
        val source = File("src/main/kotlin/com/example/inventory/InventoryService.kt").readText()
        assertFalse(
            source.contains("if (expensive != null)"),
            "InventoryService.kt should not use an explicit null guard — use the safe-call (?.) and Elvis (?:) operators instead"
        )
    }

    @Test
    fun testUsesSafeCallOperator() {
        val source = File("src/main/kotlin/com/example/inventory/InventoryService.kt").readText()
        assertTrue(
            source.contains("?."),
            "InventoryService.kt should use the safe-call operator (?.) in place of a null guard"
        )
    }

    @Test
    fun testUsesElvisOperator() {
        val source = File("src/main/kotlin/com/example/inventory/InventoryService.kt").readText()
        assertTrue(
            source.contains("?:"),
            "InventoryService.kt should use the Elvis operator (?:) to provide a default when the value is null"
        )
    }
}
