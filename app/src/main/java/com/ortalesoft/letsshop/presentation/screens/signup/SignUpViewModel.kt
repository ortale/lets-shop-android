package com.ortalesoft.letsshop.presentation.screens.signup

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ortalesoft.letsshop.data.common.Resource
import com.ortalesoft.letsshop.domain.uses_case.signup.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase
): ViewModel() {
    private val _signUpScreenState = mutableStateOf(SignUpScreenState())
    val signUpScreenState = _signUpScreenState

    fun signUp(name: String, email: String, password: String) {
        signUpUseCase(name, email, password).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _signUpScreenState.value = SignUpScreenState(user = result.data?.user)
                }
                is Resource.Error -> {
                    _signUpScreenState.value = SignUpScreenState(error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _signUpScreenState.value = SignUpScreenState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}