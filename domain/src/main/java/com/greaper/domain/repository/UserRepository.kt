package com.greaper.domain.repository

import com.greaper.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getCacheUser() : Flow<User>
}