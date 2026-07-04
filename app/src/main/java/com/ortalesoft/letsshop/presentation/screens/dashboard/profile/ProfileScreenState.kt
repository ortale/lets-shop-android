package com.ortalesoft.letsshop.presentation.screens.dashboard.profile

import com.ortalesoft.letsshop.domain.model.responses.MeResponse

sealed class ProfileScreenState {
    data object Idle : ProfileScreenState()
    data object Loading : ProfileScreenState()
    data class Success(val meResponse: MeResponse?) : ProfileScreenState()
    data class Error(val message: String) : ProfileScreenState()
}