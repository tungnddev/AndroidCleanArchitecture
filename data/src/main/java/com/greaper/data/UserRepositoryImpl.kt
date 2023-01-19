package com.greaper.data

import com.greaper.data.remote.api.UserApi
import com.greaper.domain.model.User
import com.greaper.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    private val userApi: UserApi
) : UserRepository {

    override fun getCacheUser(): Flow<User> {
        TODO("Not yet implemented")
    }

//    override fun getMyProfile(): Flow<User> {
//        TODO("Not yet implemented")
//    }
}