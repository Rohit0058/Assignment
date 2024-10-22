package com.example.assignment.model

// Data models for the items and the cart
data class Item(val name: String, val price: Double)

class Cart {
    private val items = mutableListOf<Item>()

    fun addItem(item: Item) {
        items.add(item)
    }

    fun getItems(): List<Item> {
        return items
    }

    fun getItemCount(): Int {
        return items.size
    }

    fun clearCart() {
        items.clear()
    }
}

