package com.greaper.data.remote.mapper.auth

import com.greaper.data.base.DtoMapper
import com.greaper.data.model.dto.TokenDto
import com.greaper.domain.model.Token
import javax.inject.Inject

class TokenDtoMapper @Inject constructor() : DtoMapper<Token, TokenDto>() {
    override fun mapToDomain(dto: TokenDto): Token {
        return Token(
            accessToken = dto.accessToken ?: "",
            refreshToken = dto.refreshToken ?: ""
        )
    }
}