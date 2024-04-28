package com.example.pizza_pro_2.domain.cart

import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import com.example.pizza_pro_2.domain.shared.SharedEvent
import com.example.pizza_pro_2.ui.theme.Slate

@Stable
data class CartState(
    val itemsCount: Int = 0,
    val itemsCost: Double = 0.0,
    val deliveryCost: Double = 0.0,
    val totalCost: Double = 0.0,
    val orderPlace: String = "",
    val isDialogVisible: Boolean = false,
    val buttonOption: Int = -1,
    val dialogTitleId: Int = -1,
    val dialogTextId: Int = -1,
    val toastMessageId: Int = -1,
    val dialogEvent: SharedEvent? = null,
    val dialogColor: Color = Slate
)