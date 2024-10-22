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
fun ShowcaseScreen(onNavigateToCart: () -> Unit, onNavigateToItemDetails: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Showcase Screen")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onNavigateToItemDetails) {
            Text(text = "View Item Details")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onNavigateToCart) {
            Text(text = "Go to Cart")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowcaseScreenPreview() {
    ShowcaseScreen(onNavigateToCart = {}, onNavigateToItemDetails = {})
}