package com.greaper.domain.usecase.auth

import com.greaper.domain.repository.AuthRepository
import com.greaper.domain.repository.UserRepository

class LoginUseCase(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(params: Params) {
        authRepository.login(params.email, params.password)
        val user = userRepository.getUser()
        userRepository.saveCacheUser(user)
    }

    data class Params(val email: String, val password: String)
}