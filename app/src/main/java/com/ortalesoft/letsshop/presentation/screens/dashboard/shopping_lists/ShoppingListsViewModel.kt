package com.ortalesoft.letsshop.presentation.screens.dashboard.shopping_lists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ortalesoft.letsshop.data.common.Resource
import com.ortalesoft.letsshop.domain.uses_case.shopping_list.GetShoppingListsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ShoppingListsViewModel @Inject constructor(
    private val getShoppingListsUseCase: GetShoppingListsUseCase
) : ViewModel() {
    private val _shoppingListsScreenState = MutableStateFlow<ShoppingListsScreenState>(ShoppingListsScreenState.Idle)
    val shoppingListsScreenState: StateFlow<ShoppingListsScreenState> = _shoppingListsScreenState.asStateFlow()

    init {
        getShoppingLists()
    }

    private fun getShoppingLists() {
        getShoppingListsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _shoppingListsScreenState.update { ShoppingListsScreenState.Success(shoppingLists = result.data) }
                }
                is Resource.Error -> {
                    _shoppingListsScreenState.update { ShoppingListsScreenState.Error(message = result.message ?: "An unexpected error occurred") }
                }
                is Resource.Loading -> {
                    _shoppingListsScreenState.update { ShoppingListsScreenState.Loading }
                }
            }
        }.launchIn(viewModelScope)
    }
}