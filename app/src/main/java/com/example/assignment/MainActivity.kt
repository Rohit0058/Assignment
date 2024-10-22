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
import com.example.assignment.ui.screens.CartScreen
import com.example.assignment.ui.screens.CheckoutScreen
import com.example.assignment.ui.screens.ItemDetailsScreen
import com.example.assignment.ui.screens.LoginScreen
import com.example.assignment.ui.screens.ShowcaseScreen
import com.example.assignment.ui.theme.AssignmentTheme


// Enum to manage screens
enum class Screen {
    Login,
    Showcase,
    Cart,
    ItemDetails,
    Checkout
}

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

@Composable
fun AppContent() {
    var currentScreen by remember { mutableStateOf(Screen.Login) }  // Manage screen state

    when (currentScreen) {
        Screen.Login -> LoginScreen(onLoginSuccess = { currentScreen = Screen.Showcase })  // Navigate to ShowcaseScreen
        Screen.Showcase -> ShowcaseScreen(
            onNavigateToCart = { currentScreen = Screen.Cart },
            onNavigateToItemDetails = { currentScreen = Screen.ItemDetails }
        )  // Navigate to ItemDetailsScreen
        Screen.Cart -> CartScreen(
            onNavigateBack = { currentScreen = Screen.Showcase },
            onProceedToCheckout = { currentScreen = Screen.Checkout }  // Navigate to CheckoutScreen
        )
        Screen.ItemDetails -> ItemDetailsScreen(onNavigateBack = { currentScreen = Screen.Showcase })  // Navigate back to ShowcaseScreen
        Screen.Checkout -> CheckoutScreen(onNavigateBack = { currentScreen = Screen.Showcase })  // Navigate back to ShowcaseScreen
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AssignmentTheme {
        AppContent()
    }
}
