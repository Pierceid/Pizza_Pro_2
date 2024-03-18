package com.example.pizza_pro_2.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pizza_pro_2.presentation.components.DefaultColumn
import com.example.pizza_pro_2.presentation.components.PizzaItem
import com.example.pizza_pro_2.data.DataSource
import com.example.pizza_pro_2.view_models.SharedViewModel

@Composable
fun ShopScreen(navController: NavController, sharedViewModel: SharedViewModel) {
    if (sharedViewModel.pizzas.isEmpty()) {
        sharedViewModel.addPizzas(DataSource().loadData())
    }
    val updatedPizzas = remember { mutableStateListOf(*sharedViewModel.pizzas.toTypedArray()) }

    DefaultColumn {
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            columns = GridCells.Adaptive(160.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(items = updatedPizzas, key = { it.id!! }) { pizza ->
                PizzaItem(
                    pizza = pizza,
                    onCountChanged = { updatedPizza ->
                        val index = updatedPizzas.indexOfFirst { it.id == updatedPizza.id }
                        if (index != -1) {
                            updatedPizzas[index].count = updatedPizza.count
                            sharedViewModel.pizzas[index].count = updatedPizza.count
                        }
                    },
                    onClick = {
                        sharedViewModel.addPizza(pizza)
                        navController.navigate(DETAIL_GRAPH_ROUTE) {
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    }
}
