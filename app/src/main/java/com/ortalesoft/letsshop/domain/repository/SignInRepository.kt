package com.ortalesoft.letsshop.domain.repository

import com.ortalesoft.letsshop.domain.model.responses.SignInResponse

interface SignInRepository {
    suspend fun signIn(email: String, password: String): SignInResponse
}