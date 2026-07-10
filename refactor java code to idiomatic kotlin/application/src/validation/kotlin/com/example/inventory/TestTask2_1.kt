package com.example.inventory

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File

class TestTask2_1 {

    @Test
    fun testItemIsDataClass() {
        val source = File("src/main/kotlin/com/example/inventory/Item.kt").readText()
        assertTrue(
            source.contains("data class Item("),
            "Item.kt should declare a data class with a primary constructor"
        )
    }

    @Test
    fun testNoPrimaryConstructorBackingFields() {
        val source = File("src/main/kotlin/com/example/inventory/Item.kt").readText()
        assertFalse(
            source.contains("private var name"),
            "Item.kt should not have a private backing field 'name' — use a primary constructor parameter"
        )
        assertFalse(
            source.contains("private var price"),
            "Item.kt should not have a private backing field 'price' — use a primary constructor parameter"
        )
    }
}
