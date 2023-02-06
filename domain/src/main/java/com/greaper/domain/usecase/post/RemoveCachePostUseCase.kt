package com.greaper.domain.usecase.post

import com.greaper.domain.repository.PostRepository

class RemoveCachePostUseCase(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke(id: String) =
        postRepository.removeCachePost(id)
}