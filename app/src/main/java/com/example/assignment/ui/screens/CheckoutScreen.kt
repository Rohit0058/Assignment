package com.example.assignment.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CheckoutScreen(onNavigateBack: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Checkout Screen")

        Spacer(modifier = Modifier.height(16.dp))

        // Display checkout details here
        Text(text = "Enter your payment and shipping information.")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onNavigateBack) {
            Text(text = "Complete Purchase")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CheckoutScreenPreview() {
    CheckoutScreen(onNavigateBack = {})
}

