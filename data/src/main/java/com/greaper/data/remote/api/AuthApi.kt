package com.greaper.data.remote.api

import com.greaper.data.model.dto.TokenDto
import retrofit2.http.GET

interface AuthApi {
    @GET("/login")
    suspend fun login(email: String, password: String): TokenDto
}