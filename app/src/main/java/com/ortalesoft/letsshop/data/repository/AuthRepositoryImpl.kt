package com.ortalesoft.letsshop.data.repository

import com.ortalesoft.letsshop.data.remote.LetsShopApi
import com.ortalesoft.letsshop.domain.model.User
import com.ortalesoft.letsshop.domain.model.responses.MeResponse
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
                name = name,
                email = email,
                password = password
            )
        )
    }

    override suspend fun me(): MeResponse {
        val token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiJhNGNjMjA3Ny1jOTYxLTQxNzItOWQ4MS0zZDNkOTUzMmM5NmYiLCJlbWFpbCI6ImZpcnN0QGVtYWlsLmNvbSIsImlhdCI6MTc4MzEwMDEyNCwiZXhwIjoxNzgzNzA0OTI0fQ.eV7tvbgmUcYLPfe7QAvl4AGJdvVUKOZdrZpA8iNvPqY"

        return letsShopApi.me(
            token
        )
    }
}