package com.ortalesoft.letsshop.data.repository

import com.ortalesoft.letsshop.data.local_storage.UserSessionStorage
import com.ortalesoft.letsshop.data.remote.LetsShopApi
import com.ortalesoft.letsshop.domain.model.User
import com.ortalesoft.letsshop.domain.model.responses.MeResponse
import com.ortalesoft.letsshop.domain.model.responses.SignInResponse
import com.ortalesoft.letsshop.domain.model.responses.SignUpResponse
import com.ortalesoft.letsshop.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val letsShopApi: LetsShopApi,
    private val session: UserSessionStorage
) : AuthRepository {
    override suspend fun signIn(email: String, password: String): SignInResponse {
        val response = letsShopApi.signIn(User(email = email, password = password))
        session.saveToken(response.token)
        session.saveUser(
            id = response.user.id ?: "",
            name = response.user.name ?: "",
            email = response.user.email ?: ""
        )
        return response
    }

    override suspend fun signUp(name: String, email: String, password: String): SignUpResponse {
        val response = letsShopApi.signUp(User(name = name, email = email, password = password))
        session.saveToken(response.token)
        session.saveUser(
            id = response.user.id ?: "",
            name = response.user.name ?: "",
            email = response.user.email ?: ""
        )
        return response
    }

    override suspend fun me(): MeResponse {
        return letsShopApi.me()
    }

    override suspend fun signOut() {
        session.clear()
    }
}