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
fun ItemDetailsScreen(onNavigateBack: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Item Details Screen")

        Spacer(modifier = Modifier.height(16.dp))

        // Display item details here
        Text(text = "Details about the selected item go here.")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onNavigateBack) {
            Text(text = "Back to Showcase")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemDetailsScreenPreview() {
    ItemDetailsScreen(onNavigateBack = {})
}
