package com.ortalesoft.letsshop.presentation.screens.signin

import com.ortalesoft.letsshop.domain.model.User

data class SignInScreenState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val user: User? = null
)
