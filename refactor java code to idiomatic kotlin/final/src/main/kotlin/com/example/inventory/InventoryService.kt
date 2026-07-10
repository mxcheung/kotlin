package com.example.inventory

class InventoryService(private val items: List<Item>) {

    fun itemsInCategory(category: String): List<Item> =
        items.filter { it.category == category }

    fun totalValue(): Double =
        items.sumOf { it.price * it.quantity }

    fun mostExpensive(): Item? =
        items.maxByOrNull { it.price }

    fun report(): String {
        val expensive = mostExpensive()
        val label = expensive?.name ?: "none"
        val status = when {
            items.size > 10 -> "Large"
            items.size > 3 -> "Medium"
            else -> "Small"
        }
        val byCategory = items.groupBy { it.category }
            .map { (cat, catItems) -> "$cat: ${catItems.size} item(s)" }
            .joinToString("\n  ")
        return """
            Inventory Report
            ================
            Total items: ${items.size}
            Status: $status
            Total value: ${"$"}${"%.2f".format(totalValue())}
            Most expensive: $label

            By category:
              $byCategory
        """.trimIndent()
    }
}
