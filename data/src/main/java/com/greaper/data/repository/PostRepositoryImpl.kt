package com.greaper.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.greaper.data.local.db.AppDatabase
import com.greaper.data.remote.api.PostApi
import com.greaper.data.remote.mapper.post.PostMapper
import com.greaper.data.utils.paging.PostPagingSource
import com.greaper.domain.model.Post
import com.greaper.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostRepositoryImpl @Inject constructor(
    private val api: PostApi,
    private val appDatabase: AppDatabase,
    private val mapper: PostMapper
) : PostRepository {
    override suspend fun getPost(): Flow<PagingData<Post>> {
        return Pager(PagingConfig(pageSize = PAGE_SIZE)) {
            PostPagingSource(postApi = api, pageSize = PAGE_SIZE, mapper = mapper)
        }.flow
    }

    override suspend fun getAllPost(): List<Post> {
        return api.getAllPosts().map { mapper.postDtoMapper.mapToDomain(it) }
    }

    override suspend fun getSavedPostFromLocal(): List<Post> {
        return appDatabase.postDao().getAll().map { mapper.postEntityMapper.mapToDomain(it) }
    }

    override suspend fun savePost(post: Post) {
        return appDatabase.postDao().insert(mapper.postEntityMapper.mapToEntity(post))
    }

    override suspend fun removeCachePost(id: String) {
        return appDatabase.postDao().deleteById(id)
    }

    companion object {
        const val PAGE_SIZE = 20
    }
}