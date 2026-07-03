package com.ortalesoft.letsshop.presentation.loading

data class LoadingScreenState(
    val isLoading: Boolean = false,
    val error: String? = null
)