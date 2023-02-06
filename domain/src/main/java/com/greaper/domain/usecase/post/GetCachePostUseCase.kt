package com.greaper.domain.usecase.post

import com.greaper.domain.repository.PostRepository

class GetCachePostUseCase(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke() =
        postRepository.getSavedPostFromLocal()
}