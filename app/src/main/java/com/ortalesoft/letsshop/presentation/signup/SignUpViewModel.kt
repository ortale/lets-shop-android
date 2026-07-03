package com.ortalesoft.letsshop.presentation.signup

import androidx.lifecycle.ViewModel
import com.ortalesoft.letsshop.domain.uses_case.signup.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase
): ViewModel() {
}