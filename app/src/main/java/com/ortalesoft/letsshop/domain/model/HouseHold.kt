package com.ortalesoft.letsshop.domain.model

data class HouseHold(
    val id: String,
    val name: String,
    val inviteCode: String,
    val shoppingLists: List<ShoppingList>
)