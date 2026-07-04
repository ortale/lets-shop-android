package com.ortalesoft.letsshop.domain.uses_case.shopping_list

import com.ortalesoft.letsshop.data.common.Resource
import com.ortalesoft.letsshop.domain.model.ShoppingList
import com.ortalesoft.letsshop.domain.repository.ShoppingListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetShoppingListsUseCase @Inject constructor(
    private val repository: ShoppingListRepository
) {
    operator fun invoke(): Flow<Resource<List<ShoppingList>>> = flow {
        try {
            emit(Resource.Loading())

            val shoppingLists = repository.getShoppingLists()
            emit(Resource.Success(shoppingLists))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
}