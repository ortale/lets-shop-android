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
) : ViewModel() {
    private val _signUpScreenState = mutableStateOf(SignUpScreenState())
    val signUpScreenState = _signUpScreenState

    fun onNameChanged(name: String) {
        _signUpScreenState.value =
            _signUpScreenState.value.copy(name = name)
    }

    fun onEmailChanged(email: String) {
        _signUpScreenState.value =
            _signUpScreenState.value.copy(email = email)
    }

    fun onPasswordChanged(password: String) {
        _signUpScreenState.value =
            _signUpScreenState.value.copy(password = password)
    }

    fun signUp(name: String, email: String, password: String) {
        _signUpScreenState.value = _signUpScreenState.value.copy(isLoading = true)
        signUpUseCase(name, email, password).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _signUpScreenState.value = SignUpScreenState(
                        isLoading = false,
                        user = result.data?.user,
                        error = null
                    )
                }

                is Resource.Error -> {
                    _signUpScreenState.value = SignUpScreenState(
                        isLoading = false,
                        error = result.message ?: "An unexpected error occurred"
                    )
                }

                is Resource.Loading -> {
                    _signUpScreenState.value = SignUpScreenState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}