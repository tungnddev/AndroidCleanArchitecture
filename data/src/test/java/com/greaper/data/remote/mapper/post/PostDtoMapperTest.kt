package com.greaper.data.remote.mapper.post

import com.greaper.data.model.dto.PostDto
import com.greaper.data.utils.TestUtil
import com.greaper.data.utils.toDate
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.*

class PostDtoMapperTest {
    private val mapper = PostDtoMapper()

    @Test
    fun mapToDomain_WithNotNullDto() {
        val dto = createPostDto()
        val model = mapper.mapToDomain(dto)
        // We have already test this function this another file test
        val createAtInDate = dto.createdAt.toDate()

        assertEquals(dto.id, model.id)
        assertEquals(dto.content, model.content)
        assertEquals(dto.image, model.image)
        assertEquals(createAtInDate, model.createdAt)
    }

    @Test
    fun mapToDomain_WithNullDto() {
        val dto = createPostDtoWithNull()
        val model = mapper.mapToDomain(dto)

        assertEquals("", model.id)
        assertEquals("", model.content)
        assertEquals("", model.image)
        assertEquals(Date(0), model.createdAt)
        assertEquals("", model.createdBy.id)
        assertEquals("", model.createdBy.name)
        assertEquals("", model.createdBy.avatar)
    }

    @Test
    fun mapCreatedBy_WithNotNull() {
        val dto = createCreatedByDto()
        val model = mapper.mapCreatedBy(dto)

        assertEquals(dto.id, model.id)
        assertEquals(dto.avatar, model.avatar)
        assertEquals(dto.name, model.name)
    }

    @Test
    fun mapCreatedBy_WithNull() {
        val dto = createCreatedByDtoWithNull()
        val model = mapper.mapCreatedBy(dto)

        assertEquals("", model.id)
        assertEquals("", model.avatar)
        assertEquals("", model.name)
    }


    private fun createPostDto() = PostDto(
        "1",
        TestUtil.LOREM_STRING,
        "https://fakeimg.pl/700",
        "2023-01-08T16:19:47Z",
        createCreatedByDto()
    )

    private fun createPostDtoWithNull() = PostDto(
        null,
        null,
        null,
        null,
        null
    )

    private fun createCreatedByDto() = PostDto.CreatedBy(
        id = "1",
        avatar = "https://fakeimg.pl/350",
        name = "Tran Van Nam"
    )

    private fun createCreatedByDtoWithNull() = PostDto.CreatedBy(
        id = null,
        avatar = null,
        name = null
    )


}