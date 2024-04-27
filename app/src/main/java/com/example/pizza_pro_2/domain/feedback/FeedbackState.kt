package com.example.pizza_pro_2.domain.feedback

import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import com.example.pizza_pro_2.options.Satisfaction

@Stable
data class FeedbackState(
    val satisfaction: Satisfaction = Satisfaction.GOOD,
    val deliveryTime: Boolean = true,
    val productQuality: Boolean = true,
    val customerService: Boolean = true,
    val comment: String = "",
    val followUp: Boolean = false,
    val isDialogVisible: Boolean = false,
    val buttonOption: Int = -1,
    val dialogTitleId: Int = -1,
    val dialogTextId: Int = -1,
    val toastMessageId: Int = -1,
    val dialogEvent: FeedbackEvent? = null,
    val dialogColor: Color? = null
)