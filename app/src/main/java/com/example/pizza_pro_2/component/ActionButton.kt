package com.example.pizza_pro_2.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pizza_pro_2.ui.theme.Violet
import com.example.pizza_pro_2.ui.theme.White

@Composable
fun ActionButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        modifier = modifier.height(60.dp),
        border = BorderStroke(2.dp, White),
        colors = ButtonDefaults.buttonColors(
            containerColor = Violet,
            contentColor = White
        ),
        onClick = onClick
    ) {
        Text(text = text, style = MaterialTheme.typography.titleMedium)
    }
}