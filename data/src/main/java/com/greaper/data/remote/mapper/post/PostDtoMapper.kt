package com.greaper.data.remote.mapper.post

import com.greaper.data.base.DtoMapper
import com.greaper.data.model.dto.PostDto
import com.greaper.data.utils.toDate
import com.greaper.domain.model.Post
import java.util.*
import javax.inject.Inject

class PostDtoMapper @Inject constructor() : DtoMapper<Post, PostDto>() {
    override fun mapToDomain(dto: PostDto): Post {
        return Post(
            dto.id ?: "",
            dto.content ?: "",
            dto.image ?: "",
            dto.createdAt?.toDate() ?: Date(0),
            mapCreatedBy(dto.createdBy)
        )
    }

    fun mapCreatedBy(dto: PostDto.CreatedBy?): Post.CreatedBy {
        return Post.CreatedBy(
            id = dto?.id ?: "",
            name = dto?.name ?: "",
            avatar = dto?.avatar ?: ""
        )
    }
}