package com.example.assignment.pageObjects

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeTestRule
import com.example.assignment.utils.TestConstants

class CartPage(private val rule: ComposeTestRule) {

    fun verifyItemsInCart(expectedItemCount: String) {
        rule.onNodeWithText(expectedItemCount).assertIsDisplayed()
    }

    fun proceedToCheckout() {
        rule.onNodeWithText(TestConstants.CART_BUTTON_TEXT).performClick() // Assuming there’s a 'Checkout' button
    }

    fun verifyCartScreen() {
        rule.onNodeWithText(TestConstants.CART_SCREEN).assertIsDisplayed()
    }
}
