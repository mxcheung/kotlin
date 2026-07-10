package com.example.inventory

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File

class TestTask3_2 {

    @Test
    fun testNoEqualsCallSites() {
        val source = File("src/main/kotlin/com/example/inventory/InventoryService.kt").readText()
        assertFalse(
            source.contains(".equals("),
            "InventoryService.kt should not call .equals() — use the == operator for structural equality"
        )
    }
}
