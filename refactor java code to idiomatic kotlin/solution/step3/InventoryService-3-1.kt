package com.example.inventory

class InventoryService(private val items: List<Item>) {

    fun itemsInCategory(category: String): List<Item> {
        val result = mutableListOf<Item>()
        for (item in items) {
            if (item.category.equals(category)) {
                result.add(item)
            }
        }
        return result
    }

    fun totalValue(): Double {
        var total = 0.0
        for (item in items) {
            total += item.price * item.quantity
        }
        return total
    }

    fun mostExpensive(): Item? {
        var result: Item? = null
        for (item in items) {
            if (result == null || item.price > result.price) {
                result = item
            }
        }
        return result
    }

    fun report(): String {
        val expensive = mostExpensive()
        val label = expensive?.name ?: "none"

        var status: String
        if (items.size > 10) {
            status = "Large"
        } else if (items.size > 3) {
            status = "Medium"
        } else {
            status = "Small"
        }

        val categoryMap = mutableMapOf<String, MutableList<Item>>()
        for (item in items) {
            val cat = item.category
            if (!categoryMap.containsKey(cat)) {
                categoryMap[cat] = mutableListOf()
            }
            categoryMap[cat]!!.add(item)
        }
        val byCategory = mutableListOf<String>()
        for ((cat, catItems) in categoryMap) {
            byCategory.add("$cat: ${catItems.size} item(s)")
        }

        return """
            Inventory Report
            ================
            Total items: ${items.size}
            Status: $status
            Total value: ${"$"}${"%.2f".format(totalValue())}
            Most expensive: $label

            By category:
              ${byCategory.joinToString("\n  ")}
        """.trimIndent()
    }
}
