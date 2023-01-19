package com.greaper.data.remote.mapper.user

import com.greaper.data.base.EntityMapper
import com.greaper.data.model.entity.UserEntity
import com.greaper.domain.model.User
import javax.inject.Inject

class UserEntityMapper @Inject constructor() : EntityMapper<User, UserEntity>() {
    override fun mapToDomain(entity: UserEntity): User {
        return User(
            id = entity.id,
            name = entity.name,
            countryCode = entity.countryCode,
            avatar = entity.avatar
        )
    }

    override fun mapToEntity(model: User): UserEntity {
        return UserEntity(
            id = model.id,
            name = model.name,
            countryCode = model.countryCode,
            avatar = model.avatar
        )
    }
}