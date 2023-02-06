package com.greaper.domain.usecase.auth

import com.greaper.domain.model.LoginUser
import com.greaper.domain.repository.AuthRepository
import com.greaper.domain.repository.UserRepository

class LoginUseCase(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(loginUser: LoginUser) {
        authRepository.login(loginUser)
        val user = userRepository.getUser()
        userRepository.saveCacheUser(user)
    }
}