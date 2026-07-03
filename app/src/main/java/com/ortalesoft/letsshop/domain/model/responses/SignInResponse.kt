package com.ortalesoft.letsshop.domain.model.responses

import com.ortalesoft.letsshop.domain.model.User

data class SignInResponse(
    val user: User,
    val token: String
)
