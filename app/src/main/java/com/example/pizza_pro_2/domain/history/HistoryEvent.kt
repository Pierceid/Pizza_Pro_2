package com.example.pizza_pro_2.domain.history

import com.example.pizza_pro_2.options.SortType
import com.example.pizza_pro_2.options.TableType

sealed class HistoryEvent {
    data class TableTypeChanged(val type: TableType) : HistoryEvent()
    data class SortTypeChanged(val type: SortType) : HistoryEvent()
    data class SearchQueryChanged(val query: String) : HistoryEvent()
    data class ItemSelectionChanged(val item: Any) : HistoryEvent()
    data object Remove : HistoryEvent()
    data object Clear : HistoryEvent()
}