package com.example.assignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.assignment.model.Cart
import com.example.assignment.ui.screens.CartScreen
import com.example.assignment.ui.screens.CheckoutScreen
import com.example.assignment.ui.screens.ConfirmPurchaseScreen
import com.example.assignment.ui.screens.ItemDetailsScreen
import com.example.assignment.ui.screens.LoginScreen
import com.example.assignment.ui.screens.Screen
import com.example.assignment.ui.screens.ShowcaseScreen
import com.example.assignment.ui.theme.AssignmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AssignmentTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    AppContent()
                }
            }
        }
    }
}

// Cart instance created to handle cart operations
private val cart = Cart()

@Composable
fun AppContent() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Login) }  // Manage screen state

    when (currentScreen) {
        Screen.Login -> LoginScreen(onLoginSuccess = {
            currentScreen = Screen.Showcase
        })
        Screen.Showcase -> ShowcaseScreen(
            onItemClick = { item ->
                currentScreen = Screen.ItemDetails(item)
            },
            onCartClick = {
                currentScreen = Screen.Cart
            }
        )
        is Screen.ItemDetails -> {
            val item = (currentScreen as Screen.ItemDetails).item
            ItemDetailsScreen(
                item = item,
                onAddToCart = {
                    cart.addItem(item) // Add item to cart without navigating away
                },
                onBackToShowcase = {
                    currentScreen = Screen.Showcase // Navigate back to Showcase
                }
            )
        }
        Screen.Cart -> CartScreen(cart = cart, onCheckout = {
            currentScreen = Screen.Checkout
        })
        Screen.Checkout -> CheckoutScreen(onConfirmPurchase = {
            currentScreen = Screen.ConfirmPurchase
        })
        Screen.ConfirmPurchase -> ConfirmPurchaseScreen(onFinish = {
            cart.clearCart()
            currentScreen = Screen.Showcase
        })
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AssignmentTheme {
        AppContent()
    }
}
