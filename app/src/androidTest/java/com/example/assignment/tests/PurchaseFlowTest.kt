package com.example.assignment.tests

import androidx.compose.ui.test.junit4.createComposeRule
import com.example.assignment.AppContent
import org.junit.Rule
import org.junit.Test
import com.example.assignment.pageObjects.*
import com.example.assignment.utils.TestConstants
import com.example.assignment.utils.TestUtils


class PurchaseFlowTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var loginPage: LoginPage
    private lateinit var showcasePage: ShowCasePage
    private lateinit var itemDetailsPage: ItemDetailsPage
    private lateinit var cartPage: CartPage
    private lateinit var checkoutPage: CheckoutPage

    @Test
    fun testPurchaseFlow() {
        TestUtils.initializeTestRule()
        composeTestRule.setContent {
            AppContent() // Entry point for your screens
        }

        // Initialize Page Objects
        loginPage = LoginPage(composeTestRule)
        showcasePage = ShowCasePage(composeTestRule)
        itemDetailsPage = ItemDetailsPage(composeTestRule)
        cartPage = CartPage(composeTestRule)
        checkoutPage = CheckoutPage(composeTestRule)

        // Execute Purchase Flow
        loginPage.login() // Simulate login

        showcasePage.verifyShowCaseScreen()
        showcasePage.selectFirstItem()
        itemDetailsPage.addToCart()
        itemDetailsPage.goBack()

        showcasePage.verifyShowCaseScreen()
        showcasePage.selectSecondItem()
        showcasePage.addItemToCart()
        showcasePage.goToCart()

        cartPage.verifyCartScreen()
        // Verify items in cart
        cartPage.verifyItemsInCart(TestConstants.ITEM_COUNT)

        // Proceed to checkout
        cartPage.proceedToCheckout()

        // Complete purchase
        checkoutPage.verifyCheckoutScreen()
        checkoutPage.completePurchase()

        // Verify success message
        checkoutPage.verifySuccessMessage()
    }
}
