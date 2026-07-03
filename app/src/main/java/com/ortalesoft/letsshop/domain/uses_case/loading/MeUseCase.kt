package com.ortalesoft.letsshop.domain.uses_case.loading

import com.ortalesoft.letsshop.data.common.Resource
import com.ortalesoft.letsshop.domain.model.responses.MeResponse
import com.ortalesoft.letsshop.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MeUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    operator fun invoke(): Flow<Resource<MeResponse>> = flow {
        try {
            emit(Resource.Loading())

            val meResponse = authRepository.me()
            emit(Resource.Success(meResponse))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
}