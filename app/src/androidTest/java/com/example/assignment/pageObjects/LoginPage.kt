package com.example.assignment.pageObjects

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeTestRule
import com.example.assignment.utils.TestConstants

// Class representing the Login page in the UI for testing purposes
class LoginPage(private val rule: ComposeTestRule) {

    // Method to perform the login action
    fun login() {
        // Find the node with the text of the login button and perform a click action
        rule.onNodeWithText(TestConstants.LOGIN_BUTTON_TEXT).performClick()
    }
}
