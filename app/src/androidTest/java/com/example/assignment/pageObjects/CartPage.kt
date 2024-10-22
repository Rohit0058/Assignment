package com.example.assignment.pageObjects

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeTestRule
import com.example.assignment.utils.TestConstants

// Class representing the Cart page in the UI for testing purposes
class CartPage(private val rule: ComposeTestRule) {

    // Method to proceed to the checkout process
    fun proceedToCheckout() {
        // Find the node with the text of the 'Proceed to Checkout' button and perform a click action
        rule.onNodeWithText(TestConstants.PROCEED_TO_CHECKOUT).performClick()
    }
}
