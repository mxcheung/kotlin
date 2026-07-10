package com.example.inventory

data class Item(
    val name: String,
    val category: String,
    val price: Double,
    val quantity: Int,
    val description: String? = null
)
