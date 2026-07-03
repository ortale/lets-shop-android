package com.ortalesoft.letsshop.domain.model

data class Item(
    val id: String,
    val listId: String,
    val addedById: String,
    val name: String,
    val unit: String?,
    val price: Double?,
    val isChecked: Boolean
)