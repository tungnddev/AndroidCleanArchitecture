package com.greaper.domain.usecase.post

import com.greaper.domain.repository.PostRepository
import com.greaper.domain.repository.UserRepository
import kotlinx.coroutines.flow.flatMapLatest

class GetAllPostUseCase(
    private val postRepository: PostRepository
) {
    operator fun invoke() =
        postRepository.getPost()
}