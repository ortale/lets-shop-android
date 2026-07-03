package com.ortalesoft.letsshop.presentation.screens.signin

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ortalesoft.letsshop.data.common.Resource
import com.ortalesoft.letsshop.domain.uses_case.loading.MeUseCase
import com.ortalesoft.letsshop.domain.uses_case.signin.SignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase,
    private val meUseCase: MeUseCase,
): ViewModel() {
    private val _signInScreenState = mutableStateOf(SignInScreenState())
    val signInScreenState = _signInScreenState

    fun onEmailChanged(email: String) {
        _signInScreenState.value =
            _signInScreenState.value.copy(email = email)
    }

    fun onPasswordChanged(password: String) {
        _signInScreenState.value =
            _signInScreenState.value.copy(password = password)
    }

    fun signIn(email: String, password: String) {
        signInUseCase(email, password).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _signInScreenState.value =
                        _signInScreenState.value.copy(
                            isLoading = false,
                            user = result.data?.user,
                            error = null
                        )
                }
                is Resource.Error -> {
                    _signInScreenState.value =
                        _signInScreenState.value.copy(
                            isLoading = false,
                            error = result.message ?: "An unexpected error occurred"
                        )
                }
                is Resource.Loading -> {
                    _signInScreenState.value = _signInScreenState.value.copy(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun me() {
        meUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _signInScreenState.value = SignInScreenState(user = result.data?.user)
                }
                is Resource.Error -> {
                    _signInScreenState.value = SignInScreenState(error = result.message ?: "An unexpected error occurred")
                    }
                is Resource.Loading -> {
                    _signInScreenState.value = SignInScreenState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}