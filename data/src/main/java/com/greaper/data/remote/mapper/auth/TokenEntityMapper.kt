package com.greaper.data.remote.mapper.auth

import com.greaper.data.base.EntityMapper
import com.greaper.data.model.entity.TokenEntity
import com.greaper.domain.model.Token
import javax.inject.Inject

class TokenEntityMapper @Inject constructor() : EntityMapper<Token, TokenEntity>() {
    override fun mapToDomain(entity: TokenEntity): Token {
        return Token(
            accessToken = entity.accessToken,
            refreshToken = entity.refreshToken
        )
    }

    override fun mapToEntity(model: Token): TokenEntity {
        return TokenEntity(
            accessToken = model.accessToken,
            refreshToken = model.refreshToken
        )
    }
}