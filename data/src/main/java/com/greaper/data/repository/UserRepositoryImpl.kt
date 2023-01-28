package com.greaper.data.repository

import com.greaper.data.local.pref.PrefHelper
import com.greaper.data.remote.api.UserApi
import com.greaper.data.remote.mapper.user.UserMapper
import com.greaper.domain.model.User
import com.greaper.domain.repository.UserRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    private val userApi: UserApi,
    private val prefHelper: PrefHelper,
    private val mapper: UserMapper
) : UserRepository {

    override fun getCacheUser(): User? {
        val userEntity = prefHelper.getCurrentUser() ?: return null
        return mapper.userEntityMapper.mapToDomain(userEntity)
    }

    override fun saveCacheUser(user: User) {
        prefHelper.setCurrentUser(mapper.userEntityMapper.mapToEntity(user))
    }

    override suspend fun getUser(): User {
        val userDto = userApi.getUser()
        return mapper.userDtoMapper.mapToDomain(userDto)
    }
}