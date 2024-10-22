package com.example.assignment.pageObjects

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeTestRule
import com.example.assignment.utils.TestConstants

// Class representing the Checkout page in the UI for testing purposes
class CheckoutPage(private val rule: ComposeTestRule) {

    // Method to complete the purchase process
    fun completePurchase() {
        // Find the node with the text of the 'Confirm Purchase' button and perform a click action
        rule.onNodeWithText(TestConstants.CONFIRM_PURCHASE).performClick()
    }
}
