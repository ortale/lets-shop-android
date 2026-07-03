package com.ortalesoft.letsshop.domain.uses_case.signup

import com.ortalesoft.letsshop.data.common.Resource
import com.ortalesoft.letsshop.domain.model.responses.SignUpResponse
import com.ortalesoft.letsshop.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    operator fun invoke(name: String, email: String, password: String): Flow<Resource<SignUpResponse>> = flow {
        try {
            emit(Resource.Loading())

            val signUpResponse = authRepository.signUp(name, email, password)
            emit(Resource.Success(signUpResponse))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
}