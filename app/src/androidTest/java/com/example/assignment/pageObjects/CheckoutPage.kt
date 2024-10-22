package com.example.assignment.pageObjects

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeTestRule
import com.example.assignment.utils.TestConstants

class CheckoutPage(private val rule: ComposeTestRule) {

    fun completePurchase() {
        rule.onNodeWithText(TestConstants.CONFIRM_PURCHASE).performClick()
    }

}
