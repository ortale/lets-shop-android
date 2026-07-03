package com.ortalesoft.letsshop.presentation.screens.loading

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ortalesoft.letsshop.data.common.Resource
import com.ortalesoft.letsshop.domain.uses_case.loading.MeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoadingViewModel @Inject constructor(
    private val meUseCase: MeUseCase
) : ViewModel() {

    private val _meScreenState = MutableStateFlow<LoadingScreenState>(LoadingScreenState.Idle)
    val meScreenState: StateFlow<LoadingScreenState> = _meScreenState.asStateFlow()

    init {
        me()
    }

    private fun me() {
        meUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _meScreenState.update { LoadingScreenState.Success(user = result.data?.user) }
                }
                is Resource.Error -> {
                    _meScreenState.update { LoadingScreenState.Error(message = result.message ?: "An unexpected error occurred") }
                }
                is Resource.Loading -> {
                    _meScreenState.update { LoadingScreenState.Loading }
                }
            }
        }.launchIn(viewModelScope)
    }
}