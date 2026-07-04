package com.ortalesoft.letsshop.presentation.screens.dashboard.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ortalesoft.letsshop.data.common.Resource
import com.ortalesoft.letsshop.domain.uses_case.profile.MeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val meUseCase: MeUseCase
) : ViewModel() {
    private val _profileScreenState = MutableStateFlow<ProfileScreenState>(ProfileScreenState.Idle)
    val profileScreenState: StateFlow<ProfileScreenState> = _profileScreenState.asStateFlow()

    init {
        getProfile()
    }

    private fun getProfile() {
        meUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _profileScreenState.update { ProfileScreenState.Success(meResponse = result.data) }
                }
                is Resource.Error -> {
                    _profileScreenState.update { ProfileScreenState.Error(message = result.message ?: "An unexpected error occurred") }
                }
                is Resource.Loading -> {
                    _profileScreenState.update { ProfileScreenState.Loading }
                }
            }
        }.launchIn(viewModelScope)
    }
}