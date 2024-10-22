package com.example.assignment.pageObjects

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeTestRule
import com.example.assignment.utils.TestConstants

class ItemDetailsPage(private val rule: ComposeTestRule) {

    fun addToCart() {
        rule.onNodeWithText(TestConstants.ADD_TO_CART).performClick()
    }

    fun goBack() {
        rule.onNodeWithText(TestConstants.BACK).performClick()
    }
}
