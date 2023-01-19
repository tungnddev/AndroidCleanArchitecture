package com.greaper.data.remote.api

import com.greaper.data.model.dto.UserDto
import retrofit2.http.GET

interface UserApi {
    @GET("/user")
    suspend fun getUser(): UserDto
}