package com.example.inventory

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File

class TestTask4_1 {

    @Test
    fun testNoMutableListAccumulation() {
        val source = File("src/main/kotlin/com/example/inventory/InventoryService.kt").readText()
        assertFalse(
            source.contains("mutableListOf<Item>()"),
            "InventoryService.kt should not build results into a mutableListOf — use a collection extension function instead"
        )
        assertFalse(
            source.contains("mutableMapOf<String, MutableList<Item>>()"),
            "InventoryService.kt should not build a category map manually — use groupBy instead"
        )
    }

    @Test
    fun testUsesCollectionExtensions() {
        val source = File("src/main/kotlin/com/example/inventory/InventoryService.kt").readText()
        assertTrue(
            source.contains(".filter {") || source.contains(".filter{"),
            "InventoryService.kt should use filter to replace the loop in itemsInCategory"
        )
        assertTrue(
            source.contains(".groupBy {") || source.contains(".groupBy{"),
            "InventoryService.kt should use groupBy to replace the manual category map loop"
        )
    }
}
