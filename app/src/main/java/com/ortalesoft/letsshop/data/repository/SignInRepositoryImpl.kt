package com.ortalesoft.letsshop.data.repository

import com.ortalesoft.letsshop.data.remote.LetsShopApi
import com.ortalesoft.letsshop.domain.model.User
import com.ortalesoft.letsshop.domain.model.responses.SignInResponse
import com.ortalesoft.letsshop.domain.repository.SignInRepository
import javax.inject.Inject

class SignInRepositoryImpl @Inject constructor(
    private val letsShopApi: LetsShopApi
): SignInRepository {
    override suspend fun signIn(email: String, password: String): SignInResponse {
        return letsShopApi.signIn(
            User(
                email = email,
                password = password
            )
        )
    }
}