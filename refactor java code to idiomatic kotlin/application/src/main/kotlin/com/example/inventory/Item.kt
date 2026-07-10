package com.example.inventory

class Item {
    private var name: String = ""
    private var category: String = ""
    private var price: Double = 0.0
    private var quantity: Int = 0
    private var description: String? = null

    constructor(name: String, category: String, price: Double, quantity: Int) {
        this.name = name
        this.category = category
        this.price = price
        this.quantity = quantity
    }

    constructor(name: String, category: String, price: Double, quantity: Int, description: String?) {
        this.name = name
        this.category = category
        this.price = price
        this.quantity = quantity
        this.description = description
    }

    fun getName(): String = name
    fun getCategory(): String = category
    fun getPrice(): Double = price
    fun getQuantity(): Int = quantity
    fun getDescription(): String? = description

    fun setName(name: String) { this.name = name }
    fun setCategory(category: String) { this.category = category }
    fun setPrice(price: Double) { this.price = price }
    fun setQuantity(quantity: Int) { this.quantity = quantity }
    fun setDescription(description: String?) { this.description = description }
}
