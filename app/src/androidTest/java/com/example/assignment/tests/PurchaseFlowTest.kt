package com.example.assignment.tests

import android.content.Context
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.core.app.ApplicationProvider
import com.example.assignment.AppContent
import org.junit.Rule
import org.junit.Test
import com.example.assignment.pageObjects.*
import com.example.assignment.utils.TestConstants
import com.example.assignment.utils.TestLogger
import com.example.assignment.utils.TestUtils
import org.junit.Before


class PurchaseFlowTest {

    @get:Rule
    val composeTestRule = createComposeRule() // Creates the Compose test rule

    private lateinit var loginPage: LoginPage
    private lateinit var showcasePage: ShowCasePage
    private lateinit var itemDetailsPage: ItemDetailsPage
    private lateinit var cartPage: CartPage
    private lateinit var checkoutPage: CheckoutPage
    private lateinit var testUtils: TestUtils

    /* Scenario 2.2 -
     "before steps" refer to actions that are executed before the main test logic runs.
     They are crucial for establishing a consistent state and preparing the environment for the test.
     Before steps are a foundational part of a well-structured testing strategy,
     ensuring that tests are reliable, maintainable,and easy to understand.
     They help ensure that the conditions are right for your tests to run accurately
     and provide meaningful results */
    @Before
    fun setup() {
        // Set the content to the starting screen for testing
        composeTestRule.setContent {
            AppContent() // Entry point for your screens
        }

        testUtils = TestUtils(composeTestRule)

        // Initialize Page Objects
        loginPage = LoginPage(composeTestRule)
        showcasePage = ShowCasePage(composeTestRule)
        itemDetailsPage = ItemDetailsPage(composeTestRule)
        cartPage = CartPage(composeTestRule)
        checkoutPage = CheckoutPage(composeTestRule)
    }

    //Scenario 1 - End to End Test for Purchase Flow
    @Test
    fun testPurchaseFlow() {
        // try catch in order to show failure logs
        try {
            // Execute E2E Purchase Flow
            // Ensuring we are on the Login Screen
            testUtils.assertScreenIsDisplayed(TestConstants.LOGIN_SCREEN)

            // Step 1: Simulate login on Clicking Login Button
            TestLogger.info("Attempting to log in.")
            loginPage.login()

            // Ensuring we are on the ShowCase Screen
            testUtils.assertScreenIsDisplayed(TestConstants.SHOW_CASE_SCREEN)

            // Step 2: Selecting Item 1
            TestLogger.info("Selecting the first item from the Showcase.")
            showcasePage.selectFirstItem()

            // Step 3: Adding Item 1 To Cart
            TestLogger.info("Adding the selected item to the cart.")
            itemDetailsPage.addToCart()

            // Step 4: Going Back To Showcase Screen
            TestLogger.info("Navigating back to Showcase.")
            itemDetailsPage.goBackToShowCase()

            // Ensuring we are back on the ShowCase Screen
            TestLogger.info("Selecting the second item from the Showcase.")
            testUtils.assertScreenIsDisplayed(TestConstants.SHOW_CASE_SCREEN)

            // Step 5: Selecting Item 2
            TestLogger.info("Adding the second item to the cart.")
            showcasePage.selectSecondItem()

            // Step 6: Adding Item 1 To Cart
            TestLogger.info("Going to the cart.")
            showcasePage.addItemToCart()

            // Step 7: Going Back To Showcase Screen
            TestLogger.info("Navigating back to Showcase.")
            itemDetailsPage.goBackToShowCase()

            // Ensuring we are back on the ShowCase Screen
            testUtils.assertScreenIsDisplayed(TestConstants.SHOW_CASE_SCREEN)

            // Step 7: Proceeding To Cart
            TestLogger.info("Proceeding to checkout.")
            showcasePage.goToCart()

            // Ensuring we are on the Cart Screen
            testUtils.assertScreenIsDisplayed(TestConstants.CART_SCREEN)

            // Step 8: Verifying the Items Count
            TestLogger.info("Verifying Items Count")
            testUtils.assertCartItemCount(2)

            // Step 9: Proceeding to checkout
            TestLogger.info("Proceeding to Checkout.")
            cartPage.proceedToCheckout()

            // Ensuring we are on the Checkout Screen
            testUtils.assertScreenIsDisplayed(TestConstants.CHECKOUT_SCREEN)

            // Step 10: Completing the purchase
            TestLogger.info("Completing the purchase.")
            checkoutPage.completePurchase()

            // Step 11: Verifying Success Message Screen
            testUtils.assertScreenIsDisplayed(TestConstants.SUCCESS_MESSAGE)
            TestLogger.info("Purchase flow test completed successfully.")

        } catch (e: Exception) {
            TestLogger.error("Test failed: ${e.message}")
        }
    }
}
