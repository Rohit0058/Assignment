package com.example.assignment.utils

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithText
import java.util.concurrent.TimeUnit

class TestUtils(private val rule: ComposeTestRule) {

    fun waitFor(seconds: Int) {
        try {
            TimeUnit.SECONDS.sleep(seconds.toLong())
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    fun assertScreenIsDisplayed(screenTitle: String) {
        // Use polling to wait until the screen is displayed
        rule.waitUntil {
            // Try to find the node with the specified text
            // If it exists and is displayed, return true
            try {
                rule.onNodeWithText(screenTitle).assertIsDisplayed()
                true
            } catch (e: Exception) {
                // If the node does not exist or is not displayed, return false to continue polling
                false
            }
        }

        println("Navigated to: $screenTitle")
    }

    fun assertCartItemCount(expectedCount: Int) {
        // Assert that the cart displays the expected number of items
        val cartText = if (expectedCount == 1) {
            "Total Items: $expectedCount"
        } else {
            "Total Items: $expectedCount"
        }
        rule.onNodeWithText(cartText).assertExists(cartText)
    }

}
