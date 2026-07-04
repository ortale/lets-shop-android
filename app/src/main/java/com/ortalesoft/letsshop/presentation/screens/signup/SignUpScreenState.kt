package com.ortalesoft.letsshop.presentation.screens.signup

import com.ortalesoft.letsshop.domain.model.User

data class SignUpScreenState(
    val isLoading: Boolean = false,
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val user: User? = null,
    val error: String? = null
)