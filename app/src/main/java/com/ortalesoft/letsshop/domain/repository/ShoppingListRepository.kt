package com.ortalesoft.letsshop.domain.repository

import com.ortalesoft.letsshop.domain.model.ShoppingList

interface ShoppingListRepository {
    suspend fun getShoppingLists(): List<ShoppingList>
    suspend fun createShoppingList(shoppingList: ShoppingList): List<ShoppingList>
}