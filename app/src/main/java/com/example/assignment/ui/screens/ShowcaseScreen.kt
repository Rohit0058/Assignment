package com.example.assignment.ui.screens

import androidx.compose.runtime.Composable

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.assignment.model.Item


@Composable
fun ShowcaseScreen(onItemClick: (Item) -> Unit, onCartClick: () -> Unit) {
    val items = listOf(Item("Item 1", 10.0), Item("Item 2", 15.0), Item("Item 3", 20.0))

    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Showcase Screen", modifier = Modifier.padding(16.dp))
        items.forEach { item ->
            Button(onClick = { onItemClick(item) }, modifier = Modifier.padding(8.dp)) {
                Text(text = item.name)
            }
        }
        Button(onClick = { onCartClick() }, modifier = Modifier.padding(8.dp)) {
            Text(text = "Go to Cart")
        }
    }
}