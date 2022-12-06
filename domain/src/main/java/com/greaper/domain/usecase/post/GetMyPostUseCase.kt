package com.greaper.domain.usecase.post

import com.greaper.domain.repository.PostRepository
import com.greaper.domain.repository.UserRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flatMapLatest

class GetMyPostUseCase(
    private val userRepository: UserRepository,
    private val postRepository: PostRepository
) {
    @OptIn(ExperimentalCoroutinesApi::class)
    operator fun invoke() = userRepository.getCacheUser().flatMapLatest { postRepository.getPostByUser(it.id) }
}