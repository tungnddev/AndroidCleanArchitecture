package com.greaper.data.remote.mapper.auth

import com.greaper.data.model.entity.TokenEntity
import com.greaper.data.utils.TestUtil
import com.greaper.domain.model.Token
import org.junit.Assert
import org.junit.Test

class TokenEntityMapperTest {
    private val mapper = TokenEntityMapper()

    @Test
    fun mapToDomain() {
        val entity = createTokenEntity()
        val model = mapper.mapToDomain(entity)

        Assert.assertEquals(entity.accessToken, model.accessToken)
        Assert.assertEquals(entity.refreshToken, model.refreshToken)
    }

    @Test
    fun mapToEntity() {
        val model = createTokenModel()
        val entity = mapper.mapToEntity(model)

        Assert.assertEquals(model.accessToken, entity.accessToken)
        Assert.assertEquals(model.refreshToken, entity.refreshToken)

    }

    private fun createTokenEntity() = TokenEntity(
        TestUtil.ACCESS_TOKEN,
        TestUtil.REFRESH_TOKEN,
    )

    private fun createTokenModel() = Token(
        TestUtil.ACCESS_TOKEN,
        TestUtil.REFRESH_TOKEN,
    )
}