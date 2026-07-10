package com.example.inventory

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File

class TestTask2_2 {

    @Test
    fun testNoExplicitGetterMethods() {
        val source = File("src/main/kotlin/com/example/inventory/Item.kt").readText()
        assertFalse(
            source.contains("fun getName()"),
            "Item.kt should not define an explicit getName() method — expose 'name' as a Kotlin property"
        )
        assertFalse(
            source.contains("fun getCategory()"),
            "Item.kt should not define an explicit getCategory() method — expose 'category' as a Kotlin property"
        )
    }

    @Test
    fun testNoExplicitSetterMethods() {
        val source = File("src/main/kotlin/com/example/inventory/Item.kt").readText()
        assertFalse(
            source.contains("fun setName("),
            "Item.kt should not define an explicit setName() method"
        )
        assertFalse(
            source.contains("fun setPrice("),
            "Item.kt should not define an explicit setPrice() method"
        )
    }

    @Test
    fun testCallSitesUsePropertyAccess() {
        val source = File("src/main/kotlin/com/example/inventory/InventoryService.kt").readText()
        assertFalse(
            source.contains(".getName()"),
            "InventoryService.kt should not call .getName() — use .name property access"
        )
        assertFalse(
            source.contains(".getCategory()"),
            "InventoryService.kt should not call .getCategory() — use .category property access"
        )
        assertFalse(
            source.contains(".getPrice()"),
            "InventoryService.kt should not call .getPrice() — use .price property access"
        )
        assertFalse(
            source.contains(".getQuantity()"),
            "InventoryService.kt should not call .getQuantity() — use .quantity property access"
        )
    }
}
