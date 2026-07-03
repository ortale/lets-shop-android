package com.ortalesoft.letsshop.presentation.screens.signin

import com.ortalesoft.letsshop.domain.model.User

data class SignInScreenState(
    val isLoading: Boolean = false,
    val user: User? = null,
    val error: String = ""
)
