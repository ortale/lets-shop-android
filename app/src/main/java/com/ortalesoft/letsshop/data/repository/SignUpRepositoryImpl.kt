package com.ortalesoft.letsshop.data.repository

import com.ortalesoft.letsshop.data.remote.LetsShopApi
import com.ortalesoft.letsshop.domain.model.User
import com.ortalesoft.letsshop.domain.model.responses.SignUpResponse
import com.ortalesoft.letsshop.domain.repository.SignUpRepository
import javax.inject.Inject

class SignUpRepositoryImpl @Inject constructor(
    private val letsShopApi: LetsShopApi
) : SignUpRepository {
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