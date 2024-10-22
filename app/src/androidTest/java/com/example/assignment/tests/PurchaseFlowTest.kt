package com.example.assignment.tests

import androidx.compose.ui.test.junit4.createComposeRule
import com.example.assignment.AppContent
import org.junit.Rule
import org.junit.Test
import com.example.assignment.pageObjects.*
import com.example.assignment.utils.TestConstants
import com.example.assignment.utils.TestUtils
import org.junit.Before


class PurchaseFlowTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var loginPage: LoginPage
    private lateinit var showcasePage: ShowCasePage
    private lateinit var itemDetailsPage: ItemDetailsPage
    private lateinit var cartPage: CartPage
    private lateinit var checkoutPage: CheckoutPage
    private lateinit var testUtils: TestUtils

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

    @Test
    fun testPurchaseFlow() {
        // Execute E2E Purchase Flow

        testUtils.assertScreenIsDisplayed(TestConstants.LOGIN_SCREEN)
        loginPage.login() // Simulate login

        testUtils.assertScreenIsDisplayed(TestConstants.SHOW_CASE_SCREEN)

        showcasePage.selectFirstItem()
        itemDetailsPage.addToCart()
        itemDetailsPage.goBackToShowCase()

        testUtils.assertScreenIsDisplayed(TestConstants.SHOW_CASE_SCREEN)

        showcasePage.selectSecondItem()
        showcasePage.addItemToCart()
        itemDetailsPage.goBackToShowCase()

        testUtils.assertScreenIsDisplayed(TestConstants.SHOW_CASE_SCREEN)

        showcasePage.goToCart()

        testUtils.assertScreenIsDisplayed(TestConstants.CART_SCREEN)

        testUtils.assertCartItemCount(2)

        // Proceed to checkout
        cartPage.proceedToCheckout()

        // Complete purchase
        testUtils.assertScreenIsDisplayed(TestConstants.CHECKOUT_SCREEN)
        checkoutPage.completePurchase()

        // Verify success message
        testUtils.assertScreenIsDisplayed(TestConstants.SUCCESS_MESSAGE)
    }
}
