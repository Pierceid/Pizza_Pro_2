package com.example.pizza_pro_2.domain.feedback

import com.example.pizza_pro_2.options.Satisfaction

sealed class FeedbackEvent {
    data class SatisfactionChanged(val satisfaction: Satisfaction): FeedbackEvent()
    data class DeliveryTimeChanged(val deliveryTime: Boolean): FeedbackEvent()
    data class ProductQualityChanged(val productQuality: Boolean): FeedbackEvent()
    data class CustomerServiceChanged(val customerService: Boolean): FeedbackEvent()
    data class CommentChanged(val comment: String): FeedbackEvent()
    data class FollowUpChanged(val followUp: Boolean): FeedbackEvent()
    data class DialogVisibilityChanged(val isVisible: Boolean) : FeedbackEvent()
    data class OptionChanged(val option: Int): FeedbackEvent()
    data object DiscardFeedback: FeedbackEvent()
    data object SendFeedback: FeedbackEvent()
}