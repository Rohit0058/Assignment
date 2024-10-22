package com.example.assignment.ui.screens

import com.example.assignment.model.Item

sealed class Screen {
    object Login : Screen()
    object Showcase : Screen()
    data class ItemDetails(val item: Item) : Screen()
    object Cart : Screen()
    object Checkout : Screen()
    object ConfirmPurchase : Screen()
}