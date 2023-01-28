package com.greaper.data.repository

import com.greaper.domain.model.LoginUser
import com.greaper.domain.model.Token
import com.greaper.domain.repository.AuthRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor() : AuthRepository {

    override suspend fun login(loginUser: LoginUser): Token {
        TODO("Not yet implemented")
    }
}