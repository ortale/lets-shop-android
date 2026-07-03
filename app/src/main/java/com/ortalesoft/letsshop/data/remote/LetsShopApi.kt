package com.ortalesoft.letsshop.data.remote

import com.ortalesoft.letsshop.domain.model.ShoppingList
import com.ortalesoft.letsshop.domain.model.User
import com.ortalesoft.letsshop.domain.model.responses.MeResponse
import com.ortalesoft.letsshop.domain.model.responses.SignInResponse
import com.ortalesoft.letsshop.domain.model.responses.SignUpResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface LetsShopApi {
    @GET("/api/v1/households/:householdId/lists")
    suspend fun getShoppingLists(): List<ShoppingList>

    @POST("/api/v1/households/:householdId/lists")
    suspend fun createShoppingList(@Body shoppingList: ShoppingList): List<ShoppingList>

    @POST("/api/v1/auth/register")
    suspend fun signUp(@Body user: User): SignUpResponse

    @POST("/api/v1/auth/login")
    suspend fun signIn(@Body user: User): SignInResponse

    @GET("/api/v1/auth/me")
    suspend fun me(): MeResponse
}

/*

// ── Auth ───────────────────────────────────────────────
router.post('/auth/register', register);
router.post('/auth/login', login);
router.get('/auth/me', authenticate, me);

// ── Households ─────────────────────────────────────────
router.post('/households', authenticate, createHousehold);
router.post('/households/join', authenticate, joinHousehold);

// ── Shopping Lists ─────────────────────────────────────
router.get('/households/:householdId/lists', authenticate, getLists);
router.post('/households/:householdId/lists', authenticate, createList);
router.patch('/households/:householdId/lists/:listId', authenticate, updateList);
router.delete('/households/:householdId/lists/:listId', authenticate, deleteList);

// ── Items ──────────────────────────────────────────────
router.get('/lists/:listId/items', authenticate, getItems);
router.post('/lists/:listId/items', authenticate, createItem);
router.patch('/lists/:listId/items/:itemId', authenticate, updateItem);
router.patch('/lists/:listId/items/:itemId/toggle', authenticate, toggleItem);
router.delete('/lists/:listId/items/:itemId', authenticate, deleteItem);
router.delete('/lists/:listId/items/checked', authenticate, clearCheckedItems);

// ── Complete a list (done shopping) ───────────────────
router.patch('/households/:householdId/lists/:listId/complete', authenticate, completeList);

 */