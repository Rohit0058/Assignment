package com.example.assignment.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule

abstract class BaseScreen {

    private val composeTestRule = createComposeRule()


    // Navigate to next screen
    fun navigateTo(nextScreen: @Composable () -> Unit, screenName: String) {
        val composeTestRule = createComposeRule()
        composeTestRule.setContent {
            nextScreen()
        }
        waitForScreenToLoad(screenName)
    }

    // Wait for screen to load
    private fun waitForScreenToLoad(screenName: String) {
        composeTestRule.onNodeWithText(screenName, useUnmergedTree = true)
            .assertIsDisplayed()
        logCurrentScreen(screenName)
    }

    // Log screen name
    private fun logCurrentScreen(screenName: String) {
        println("Navigated to screen: $screenName")
    }
}
