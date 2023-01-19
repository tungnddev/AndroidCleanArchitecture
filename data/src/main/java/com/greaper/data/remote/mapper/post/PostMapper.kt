package com.greaper.data.remote.mapper.post

import javax.inject.Inject

class PostMapper @Inject constructor(
    val postDtoMapper: PostDtoMapper,
    val postEntityMapper: PostEntityMapper
)

