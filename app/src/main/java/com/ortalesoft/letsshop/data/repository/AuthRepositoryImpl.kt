package com.ortalesoft.letsshop.data.repository

import com.ortalesoft.letsshop.data.remote.LetsShopApi
import com.ortalesoft.letsshop.domain.model.User
import com.ortalesoft.letsshop.domain.model.responses.SignInResponse
import com.ortalesoft.letsshop.domain.model.responses.SignUpResponse
import com.ortalesoft.letsshop.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val letsShopApi: LetsShopApi
): AuthRepository {
    override suspend fun signIn(email: String, password: String): SignInResponse {
        return letsShopApi.signIn(
            User(
                email = email,
                password = password
            )
        )
    }

    override suspend fun signUp(
        name: String,
        email: String,
        password: String
    ): SignUpResponse {
        return letsShopApi.signUp(
            User(
                name = email,
                email = email,
                password = password
            )
        )
    }
}