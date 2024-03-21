package com.example.pizza_pro_2.domain

import androidx.compose.runtime.Stable
import com.example.pizza_pro_2.models.Pizza

@Stable
data class SharedFormState(
    val searchQuery: String = "",
    val selectedPizza: Pizza? = null,
    val allPizzas: List<Pizza> = emptyList(),
    val filteredPizzas: List<Pizza> = emptyList(),
    val orderedPizzas: List<Pizza> = emptyList(),
    val itemsCost: Double = 0.0
)