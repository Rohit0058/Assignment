package com.example.assignment.pageObjects

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeTestRule
import com.example.assignment.utils.TestConstants

// Class representing the Item Details page in the UI for testing purposes
class ItemDetailsPage(private val rule: ComposeTestRule) {

    // Method to add the item to the cart
    fun addToCart() {
        // Find the node with the text of the 'Add to Cart' button and perform a click action
        rule.onNodeWithText(TestConstants.ADD_TO_CART).performClick()
    }

    // Method to navigate back to the Showcase page
    fun goBackToShowCase() {
        // Find the node with the text of the 'Back to Showcase' button and perform a click action
        rule.onNodeWithText(TestConstants.BACK_TO_SHOWCASE).performClick()
    }
}
