package com.greaper.domain.model

data class Token(
    val accessToken: String,
    val refreshToken: String
) : Model()