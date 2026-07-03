package com.ortalesoft.letsshop.presentation.screens.signup

import com.ortalesoft.letsshop.domain.model.User

data class SignUpScreenState(
    val isLoading: Boolean = false,
    val user: User? = null,
    val error: String = ""
)