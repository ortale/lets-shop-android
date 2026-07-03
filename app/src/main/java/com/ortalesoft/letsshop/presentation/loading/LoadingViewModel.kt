package com.ortalesoft.letsshop.presentation.loading

import androidx.lifecycle.ViewModel
import com.ortalesoft.letsshop.domain.uses_case.loading.LoadingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoadingViewModel @Inject constructor(
    private val loadingUseCase: LoadingUseCase
): ViewModel() {
}