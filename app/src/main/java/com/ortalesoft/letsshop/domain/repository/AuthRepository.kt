package com.ortalesoft.letsshop.domain.repository

import com.ortalesoft.letsshop.domain.model.responses.MeResponse
import com.ortalesoft.letsshop.domain.model.responses.SignInResponse
import com.ortalesoft.letsshop.domain.model.responses.SignUpResponse

interface AuthRepository {
    suspend fun signIn(email: String, password: String): SignInResponse
    suspend fun signUp(name: String, email: String, password: String): SignUpResponse
    suspend fun me(): MeResponse
}