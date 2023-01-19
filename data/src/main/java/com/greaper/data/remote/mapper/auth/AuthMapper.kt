package com.greaper.data.remote.mapper.auth

import javax.inject.Inject

class AuthMapper @Inject constructor(
    val tokenEntityMapper: TokenEntityMapper,
    val tokenDtoMapper: TokenDtoMapper
)