package com.ortalesoft.letsshop.presentation.screens.dashboard.shopping_lists

import com.ortalesoft.letsshop.domain.model.ShoppingList

sealed class ShoppingListsScreenState {
    data object Idle : ShoppingListsScreenState()
    data object Loading : ShoppingListsScreenState()
    data class Success(val shoppingLists: List<ShoppingList>?) : ShoppingListsScreenState()
    data class Error(val message: String) : ShoppingListsScreenState()
}