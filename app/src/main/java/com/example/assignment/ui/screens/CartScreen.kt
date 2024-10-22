package com.example.assignment.ui.screens

import androidx.compose.runtime.Composable

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CartScreen(onNavigateBack: () -> Unit, onProceedToCheckout: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Cart Screen")

        Spacer(modifier = Modifier.height(16.dp))

        // Dummy text for cart items; replace with actual cart items in a real app
        Text(text = "Item 1")
        Text(text = "Item 2")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onProceedToCheckout) {
            Text(text = "Proceed to Checkout")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onNavigateBack) {
            Text(text = "Back to Showcase")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CartScreenPreview() {
    CartScreen(onNavigateBack = {}, onProceedToCheckout = {})
}
