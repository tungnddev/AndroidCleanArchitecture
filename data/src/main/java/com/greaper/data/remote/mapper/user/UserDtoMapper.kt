package com.greaper.data.remote.mapper.user

import com.greaper.data.base.DtoMapper
import com.greaper.data.model.dto.UserDto
import com.greaper.domain.model.User
import javax.inject.Inject

class UserDtoMapper @Inject constructor() : DtoMapper<User, UserDto>() {
    override fun mapToDomain(dto: UserDto): User {
        return User(
            id = dto.id ?: "",
            name = dto.name ?: "",
            countryCode = dto.countryCode ?: "",
            avatar = dto.avatar ?: ""
        )
    }
}