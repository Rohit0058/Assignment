package com.example.assignment.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.assignment.model.Item

@Composable
fun ItemDetailsScreen(item: Item, onAddToCart: () -> Unit, onBackToShowcase: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Item Details", style = MaterialTheme.typography.h5)
        Text(text = "Item: ${item.name}, Price: \$${item.price}")
        Button(onClick = { onAddToCart() }, modifier = Modifier.padding(8.dp)) {
            Text(text = "Add to Cart")
        }
        Button(onClick = { onBackToShowcase() }, modifier = Modifier.padding(8.dp)) {
            Text(text = "Back to Showcase")
        }
    }
}
