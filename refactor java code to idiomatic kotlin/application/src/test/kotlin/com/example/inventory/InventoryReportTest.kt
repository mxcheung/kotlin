package com.example.inventory

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class InventoryReportTest {

    private val items = listOf(
        Item("Laptop", "Electronics", 999.99, 5),
        Item("Desk Chair", "Furniture", 249.99, 12),
        Item("Monitor", "Electronics", 399.99, 8, "27-inch 4K display"),
        Item("Standing Desk", "Furniture", 599.99, 3),
        Item("Keyboard", "Electronics", 79.99, 20, "Mechanical"),
        Item("Notebook", "Stationery", 4.99, 100),
        Item("Pen Set", "Stationery", 12.99, 50, null)
    )

    private val service = InventoryService(items)

    @Test
    fun `itemsInCategory returns only items in the given category`() {
        val electronics = service.itemsInCategory("Electronics")
        assertEquals(3, electronics.size)
        assertTrue(electronics.all { it.getCategory() == "Electronics" })
    }

    @Test
    fun `totalValue returns correct sum of price times quantity`() {
        val expected = (999.99 * 5) + (249.99 * 12) + (399.99 * 8) +
                (599.99 * 3) + (79.99 * 20) + (4.99 * 100) + (12.99 * 50)
        assertEquals(expected, service.totalValue(), 0.001)
    }

    @Test
    fun `mostExpensive returns item with highest price`() {
        val item = service.mostExpensive()
        assertNotNull(item)
        assertEquals("Laptop", item!!.getName())
    }

    @Test
    fun `report contains total items count`() {
        assertTrue(service.report().contains("Total items: 7"))
    }

    @Test
    fun `report contains most expensive item name`() {
        assertTrue(service.report().contains("Most expensive: Laptop"))
    }

    @Test
    fun `report contains inventory status`() {
        assertTrue(service.report().contains("Status:"))
    }

    @Test
    fun `report contains all category names`() {
        val report = service.report()
        assertTrue(report.contains("Electronics"))
        assertTrue(report.contains("Furniture"))
        assertTrue(report.contains("Stationery"))
    }

    @Test
    fun `mostExpensive returns null for empty inventory`() {
        val emptyService = InventoryService(emptyList())
        assertNull(emptyService.mostExpensive())
    }

    @Test
    fun `report handles null description without error`() {
        assertDoesNotThrow { service.report() }
    }
}
