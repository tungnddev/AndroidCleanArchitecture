package com.greaper.data.remote.mapper.user

import javax.inject.Inject

class UserMapper @Inject constructor(
    val userDtoMapper: UserDtoMapper,
    val userEntityMapper: UserEntityMapper
)