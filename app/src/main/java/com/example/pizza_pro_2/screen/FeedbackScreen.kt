package com.example.pizza_pro_2.screen

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.pizza_pro_2.component.DefaultColumn

@Composable
fun FeedbackScreen(navController : NavController) {
    DefaultColumn {
        Text(
            text = "feedback",
            style = MaterialTheme.typography.titleLarge
        )
    }
}