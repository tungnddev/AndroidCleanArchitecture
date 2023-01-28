package com.greaper.domain.repository

import com.greaper.domain.model.LoginUser
import com.greaper.domain.model.Token

interface AuthRepository {
    suspend fun login(loginUser: LoginUser): Token
}