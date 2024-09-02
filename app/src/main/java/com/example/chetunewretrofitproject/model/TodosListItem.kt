package com.example.chetunewretrofitproject.model

data class TodosListItem(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)