package com.greaper.data.repository

import com.greaper.data.remote.api.AuthApi
import com.greaper.data.remote.mapper.auth.AuthMapper
import com.greaper.domain.model.LoginUser
import com.greaper.domain.model.Token
import com.greaper.domain.repository.AuthRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val api: AuthApi,
    private val mapper: AuthMapper
) : AuthRepository {

    override suspend fun login(loginUser: LoginUser): Token {
        val dto = api.login(loginUser)
        return mapper.tokenDtoMapper.mapToDomain(dto)
    }
}