package com.ortalesoft.letsshop.domain.repository

import com.ortalesoft.letsshop.domain.model.responses.SignUpResponse

interface SignUpRepository {
    suspend fun signUp(name: String, email: String, password: String): SignUpResponse
}