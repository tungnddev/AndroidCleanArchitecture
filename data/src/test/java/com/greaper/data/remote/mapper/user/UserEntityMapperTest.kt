package com.greaper.data.remote.mapper.user

import com.greaper.data.model.entity.UserEntity
import com.greaper.domain.model.User
import org.junit.Assert
import org.junit.Test

class UserEntityMapperTest {

    private val mapper = UserEntityMapper()

    @Test
    fun mapToDomain() {
        val entity = createUserEntity()
        val model = mapper.mapToDomain(entity)

        Assert.assertEquals(entity.id, model.id)
        Assert.assertEquals(entity.name, model.name)
        Assert.assertEquals(entity.countryCode, model.countryCode)
        Assert.assertEquals(entity.avatar, model.avatar)
    }

    @Test
    fun mapToEntity() {
        val model = createUserModel()
        val entity = mapper.mapToEntity(model)

        Assert.assertEquals(model.id, entity.id)
        Assert.assertEquals(model.name, entity.name)
        Assert.assertEquals(model.countryCode, entity.countryCode)
        Assert.assertEquals(model.avatar, entity.avatar)

    }

    private fun createUserEntity() = UserEntity(
        "1",
        "Tran Van Nam",
        "VN",
        "https://fakeimg.pl/700",
    )

    private fun createUserModel() = User(
        "1",
        "Tran Van Nam",
        "VN",
        "https://fakeimg.pl/700",
    )
}