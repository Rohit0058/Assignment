package com.example.assignment.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CheckoutScreen(onConfirmPurchase: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Checkout Screen", style = MaterialTheme.typography.h5)
        TextField(
            value = "Enter Address",
            onValueChange = {},
            modifier = Modifier.padding(16.dp)
        )
        Button(onClick = { onConfirmPurchase() }, modifier = Modifier.padding(8.dp)) {
            Text(text = "Confirm Purchase")
        }
    }
}
