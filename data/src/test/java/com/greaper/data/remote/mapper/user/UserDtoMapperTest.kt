package com.greaper.data.remote.mapper.user

import com.greaper.data.model.dto.UserDto
import org.junit.Assert.assertEquals
import org.junit.Test

class UserDtoMapperTest {
    private val mapper = UserDtoMapper()

    @Test
    fun mapToDomain_WithNotNullDto() {
        val dto = createUserDto()
        val model = mapper.mapToDomain(dto)
        // We have already test this function this another file test

        assertEquals(dto.id, model.id)
        assertEquals(dto.name, model.name)
        assertEquals(dto.countryCode, model.countryCode)
        assertEquals(dto.avatar, model.avatar)
    }

    @Test
    fun mapToDomain_WithNullDto() {
        val dto = createUserDtoWithNull()
        val model = mapper.mapToDomain(dto)

        assertEquals("", model.id)
        assertEquals("", model.name)
        assertEquals("", model.countryCode)
        assertEquals("", model.avatar)
    }

    private fun createUserDto() = UserDto(
        "1",
        "Tran Van Nam",
        "VN",
        "https://fakeimg.pl/350",
    )

    private fun createUserDtoWithNull() = UserDto(
        null,
        null,
        null,
        null
    )

}