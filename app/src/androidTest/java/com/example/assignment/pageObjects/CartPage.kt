package com.example.assignment.pageObjects

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeTestRule
import com.example.assignment.utils.TestConstants

class CartPage(private val rule: ComposeTestRule) {

    fun proceedToCheckout() {
        rule.onNodeWithText(TestConstants.PROCEED_TO_CHECKOUT).performClick()
    }

}
