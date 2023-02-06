package com.greaper.domain.repository

import androidx.paging.PagingData
import com.greaper.domain.model.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository : Repository {
    suspend fun getPost() : Flow<PagingData<Post>>
    suspend fun getAllPost() : List<Post>
    suspend fun getSavedPostFromLocal(): List<Post>
    suspend fun savePost(post: Post)
    suspend fun removeCachePost(id: String)
}