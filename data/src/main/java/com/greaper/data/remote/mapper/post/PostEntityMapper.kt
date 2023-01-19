package com.greaper.data.remote.mapper.post

import com.google.gson.Gson
import com.greaper.data.base.EntityMapper
import com.greaper.data.model.entity.PostEntity
import com.greaper.domain.model.Post
import javax.inject.Inject

class PostEntityMapper @Inject constructor() : EntityMapper<Post, PostEntity>() {

    private val gson = Gson()

    override fun mapToDomain(entity: PostEntity): Post {
        return Post(
            id = entity.id,
            content = entity.content,
            image = entity.image,
            createdAt = entity.createdAt,
            createdBy = mapCreatedByToDomain(entity.createdBy)
        )
    }

    override fun mapToEntity(model: Post): PostEntity {
        return PostEntity(
            id = model.id,
            content = model.content,
            image = model.image,
            createdAt = model.createdAt,
            createdBy = mapCreatedByToEntity(model.createdBy)
        )
    }

    fun mapCreatedByToDomain(json: String): Post.CreatedBy {
        val createdByEntity = gson.fromJson(json, PostEntity.CreatedBy::class.java)
        return Post.CreatedBy(
            id = createdByEntity.id,
            name = createdByEntity.name,
            avatar = createdByEntity.avatar
        )
    }

    fun mapCreatedByToEntity(createdBy: Post.CreatedBy): String {
        val createdByEntity = PostEntity.CreatedBy(
            id = createdBy.id,
            name = createdBy.name,
            avatar = createdBy.avatar
        )
        return gson.toJson(createdByEntity)
    }
}