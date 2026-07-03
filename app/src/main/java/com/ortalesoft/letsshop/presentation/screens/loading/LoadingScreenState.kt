package com.ortalesoft.letsshop.presentation.screens.loading

import com.ortalesoft.letsshop.domain.model.User

sealed class LoadingScreenState {
    data object Idle : LoadingScreenState()
    data object Loading : LoadingScreenState()
    data class Success(val user: User?) : LoadingScreenState()
    data class Error(val message: String) : LoadingScreenState()
}