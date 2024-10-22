package com.example.assignment.ui.screens

import androidx.compose.runtime.Composable

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assignment.model.Cart

@Composable
fun CartScreen(cart: Cart, onCheckout: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Cart Screen", style = MaterialTheme.typography.h5, modifier = Modifier.padding(16.dp))
        Text(text = "Total Items: ${cart.getItemCount()}", modifier = Modifier.padding(8.dp))
        cart.getItems().forEach { item ->
            Text(text = "${item.name} - \$${item.price}", modifier = Modifier.padding(4.dp))
        }
        Button(onClick = { onCheckout() }, modifier = Modifier.padding(8.dp)) {
            Text(text = "Proceed to Checkout")
        }
    }
}

