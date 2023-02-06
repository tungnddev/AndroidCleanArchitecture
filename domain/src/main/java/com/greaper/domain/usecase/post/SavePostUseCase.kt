package com.greaper.domain.usecase.post

import com.greaper.domain.model.Post
import com.greaper.domain.repository.PostRepository

class SavePostUseCase(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke(post: Post) =
        postRepository.savePost(post)
}