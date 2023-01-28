package com.greaper.data.remote.api

import com.greaper.data.model.dto.TokenDto
import com.greaper.data.remote.factory.RetrofitResponse
import com.greaper.domain.model.LoginUser
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("/login")
    suspend fun login(@Body body: LoginUser): RetrofitResponse<TokenDto>
}