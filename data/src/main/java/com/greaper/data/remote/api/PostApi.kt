package com.greaper.data.remote.api

import com.greaper.data.model.dto.PostDto
import retrofit2.http.GET
import retrofit2.http.Query

interface PostApi {
    @GET("/posts")
    suspend fun getPosts(@Query("page") page: Int, @Query("limit") limit: Int): List<PostDto>

    @GET("/posts")
    suspend fun getAllPosts(): List<PostDto>
}