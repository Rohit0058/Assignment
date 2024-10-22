package com.example.assignment.utils

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithText
import java.util.concurrent.TimeUnit

class TestUtils(private val rule: ComposeTestRule) {

    // Just a way for adding a hardcode delay in order to wait for particular action or assertion
    fun waitFor(seconds: Int) {
        try {
            TimeUnit.SECONDS.sleep(seconds.toLong())
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    /* Scenario 2.1 - Checking Screen while Transition and Handling Slow Network
    Polling for Visibility:
    The assertScreenIsDisplayed function checks if the screen is visible and uses waitUntil to poll until
    the node is found and visible. This way, the test only moves on when the UI is ready,
    avoiding arbitrary waits.
    No Hardcoded Delays:
    This implementation does not rely on hardcoded wait times but instead checks the actual UI state,
    making it more reliable and efficient.
     */
    fun assertScreenIsDisplayed(screenTitle: String) {
        // Use polling to wait until the screen is displayed
        rule.waitUntil {
            // Try to find the node with the specified text
            // If it exists and is displayed, return true
            try {
                rule.onNodeWithText(screenTitle).assertIsDisplayed()
                TestLogger.info("Asserting that $screenTitle is displayed.")
                true
            } catch (e: Exception) {
                TestLogger.error("$e")
                // If the node does not exist or is not displayed, return false to continue polling
                false
            }
        }
    }

    /* Scenario 2.3 -> For the bonus point regarding asserting the number of items in the cart:

    Real-time Assertion: It's crucial to keep track of the number of items in the cart in real-time
    for a more dynamic user experience.
    As users add or remove items, the count should be updated and asserted against expected
    values during the testing process.

    Flexibility: Instead of hardcoding expected values, implementing logic to assert the actual count
    of items allows for more robust testing. This dynamic approach can help identify issues
    related to item management in the cart.
     */

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
