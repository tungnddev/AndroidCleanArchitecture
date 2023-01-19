package com.greaper.domain.repository

import com.greaper.domain.model.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository : Repository {
    fun getPost() : Flow<List<Post>>
    fun getSavedPostFromLocal(): Flow<List<Post>>
}