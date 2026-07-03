package com.ortalesoft.letsshop.data.repository

import com.ortalesoft.letsshop.data.remote.LetsShopApi
import com.ortalesoft.letsshop.domain.model.ShoppingList
import com.ortalesoft.letsshop.domain.repository.ShoppingListRepository
import javax.inject.Inject

class ShoppingListRepositoryImpl @Inject constructor(
    private val letsShopApi: LetsShopApi
) : ShoppingListRepository {
    override suspend fun getShoppingLists(): List<ShoppingList> {
        return letsShopApi.getShoppingLists()
    }

    override suspend fun createShoppingList(shoppingList: ShoppingList): List<ShoppingList> {
        return letsShopApi.createShoppingList(shoppingList)
    }
}