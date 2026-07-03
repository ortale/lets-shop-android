package com.ortalesoft.letsshop.domain.uses_case.signin

import com.ortalesoft.letsshop.data.common.Resource
import com.ortalesoft.letsshop.domain.model.responses.SignInResponse
import com.ortalesoft.letsshop.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    operator fun invoke(email: String, password: String): Flow<Resource<SignInResponse>> = flow {
        try {
            emit(Resource.Loading())

            val signInResponse = authRepository.signIn(email, password)
            emit(Resource.Success(signInResponse))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
}