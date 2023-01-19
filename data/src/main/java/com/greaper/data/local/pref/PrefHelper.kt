package com.greaper.data.local.pref

import com.greaper.data.model.entity.TokenEntity
import com.greaper.data.model.entity.UserEntity

interface PrefHelper {
    fun isFirstRun(): Boolean

    fun setFirstRun(boolean: Boolean)

    fun getCurrentUser(): UserEntity?

    fun setCurrentUser(user: UserEntity)

    fun getToken(): TokenEntity?

    fun setToken(token: TokenEntity)
}