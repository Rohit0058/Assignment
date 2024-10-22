package com.example.assignment.pageObjects

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeTestRule
import com.example.assignment.utils.TestConstants

// Class representing the Showcase page in the UI for testing purposes
class ShowCasePage(private val rule: ComposeTestRule) {

    // Method to select the first item in the showcase
    fun selectFirstItem() {
        // Find the node with the text of the first item and perform a click action
        rule.onNodeWithText(TestConstants.FIRST_ITEM).performClick()
    }

    // Method to select the second item in the showcase
    fun selectSecondItem() {
        // Find the node with the text of the second item and perform a click action
        rule.onNodeWithText(TestConstants.SECOND_ITEM).performClick()
    }

    // Method to add the currently selected item to the cart
    fun addItemToCart() {
        // Find the node with the text 'Add to Cart' and perform a click action
        rule.onNodeWithText(TestConstants.ADD_TO_CART).performClick()
    }

    // Method to navigate to the cart from the showcase page
    fun goToCart() {
        // Find the node with the text of the cart button and perform a click action
        rule.onNodeWithText(TestConstants.CART_BUTTON_TEXT).performClick()
    }
}
