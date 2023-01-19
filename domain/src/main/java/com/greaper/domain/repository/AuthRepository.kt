package com.greaper.domain.repository

import com.greaper.domain.model.Token

interface AuthRepository {
    suspend fun login(email: String, password: String): Token
}