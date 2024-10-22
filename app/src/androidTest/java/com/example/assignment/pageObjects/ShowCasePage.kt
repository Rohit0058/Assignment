package com.example.assignment.pageObjects

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeTestRule
import com.example.assignment.utils.TestConstants

class ShowCasePage(private val rule: ComposeTestRule) {

    fun selectFirstItem() {
        rule.onNodeWithText(TestConstants.FIRST_ITEM).performClick()
    }

    fun selectSecondItem() {
        rule.onNodeWithText(TestConstants.SECOND_ITEM).performClick()
    }

    fun verifyShowCaseScreen() {
        rule.onNodeWithText(TestConstants.SHOW_CASE_SCREEN).assertIsDisplayed()
    }

    fun addItemToCart() {
        rule.onNodeWithText(TestConstants.ADD_TO_CART).performClick()
    }

    fun goToCart() {
        rule.onNodeWithText(TestConstants.CART_BUTTON_TEXT).performClick()
    }
}
