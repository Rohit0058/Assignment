package com.example.assignment.pageObjects

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeTestRule
import com.example.assignment.utils.TestConstants

class LoginPage(private val rule: ComposeTestRule) {

    fun login() {
        rule.onNodeWithText(TestConstants.LOGIN_BUTTON_TEXT).performClick()
    }

}
