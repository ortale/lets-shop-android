package com.ortalesoft.letsshop.domain.model

data class ShoppingList(
    val id: String,
    val householdId: String,
    val name: String,
    val isCompleted: Boolean,
    val completedAt: String?,
    val items: List<Item>
)