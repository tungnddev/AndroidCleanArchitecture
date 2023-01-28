package com.greaper.data.repository

import com.greaper.data.local.db.AppDatabase
import com.greaper.data.remote.api.PostApi
import com.greaper.data.remote.mapper.post.PostMapper
import com.greaper.domain.model.Post
import com.greaper.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostRepositoryImpl @Inject constructor(
    private val api: PostApi,
    private val appDatabase: AppDatabase,
    private val mapper: PostMapper
) : PostRepository {
    override fun getPost(): Flow<List<Post>> {
        return flow {
            api.getPosts(1, 10).map { mapper.postDtoMapper.mapToDomain(it) }
        }

    }

    override fun getSavedPostFromLocal(): Flow<List<Post>> {
        TODO("Not yet implemented")
    }

}