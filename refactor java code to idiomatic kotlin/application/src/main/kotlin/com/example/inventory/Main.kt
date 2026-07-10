package com.example.inventory

fun main() {
    val items = listOf(
        Item("Laptop", "Electronics", 999.99, 5),
        Item("Desk Chair", "Furniture", 249.99, 12),
        Item("Monitor", "Electronics", 399.99, 8, "27-inch 4K display"),
        Item("Standing Desk", "Furniture", 599.99, 3),
        Item("Keyboard", "Electronics", 79.99, 20, "Mechanical"),
        Item("Notebook", "Stationery", 4.99, 100),
        Item("Pen Set", "Stationery", 12.99, 50, null)
    )

    val service = InventoryService(items)
    println(service.report())
}
