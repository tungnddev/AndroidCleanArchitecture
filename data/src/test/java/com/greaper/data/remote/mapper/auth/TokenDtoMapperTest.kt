package com.greaper.data.remote.mapper.auth

import com.greaper.data.model.dto.TokenDto
import com.greaper.data.utils.TestUtil
import org.junit.Assert
import org.junit.Test

class TokenDtoMapperTest {
    private val mapper = TokenDtoMapper()

    @Test
    fun mapToDomain_WithNotNullDto() {
        val dto = createTokenDto()
        val model = mapper.mapToDomain(dto)

        Assert.assertEquals(dto.accessToken, model.accessToken)
        Assert.assertEquals(dto.refreshToken, model.refreshToken)
    }

    @Test
    fun mapToDomain_WithNullDto() {
        val dto = createTokenDtoWithNull()
        val model = mapper.mapToDomain(dto)

        Assert.assertEquals("", model.accessToken)
        Assert.assertEquals("", model.accessToken)
    }

    private fun createTokenDto() = TokenDto(
        TestUtil.ACCESS_TOKEN,
        TestUtil.REFRESH_TOKEN,
    )

    private fun createTokenDtoWithNull() = TokenDto(
        null,
        null,
    )
}