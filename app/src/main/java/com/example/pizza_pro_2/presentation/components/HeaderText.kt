package com.example.pizza_pro_2.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pizza_pro_2.ui.theme.Magenta

@Composable
fun HeaderText(text: String, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.headlineLarge,
        color = Magenta
    )
}