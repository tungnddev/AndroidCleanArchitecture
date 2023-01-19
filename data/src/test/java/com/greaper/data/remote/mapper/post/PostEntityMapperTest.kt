package com.greaper.data.remote.mapper.post

import com.greaper.data.model.entity.PostEntity
import com.greaper.data.utils.TestUtil
import com.greaper.domain.model.Post
import org.junit.Assert.*
import org.junit.Test
import java.util.*

class PostEntityMapperTest {
    private val mapper = PostEntityMapper()

    private val dateTest = Date()
    private val jsonCreatedBy = "{"+
            "\"id\":\"1\"," +
            "\"name\":\"Tran Van Nam\"," +
            "\"avatar\":\"https://fakeimg.pl/350\"" +
            "}"

    @Test
    fun mapCreatedByToDomain() {
        val createByEntity = createPostEntity().createdBy
        val model = mapper.mapCreatedByToDomain(createByEntity)

        assertEquals("1", model.id)
        assertEquals("https://fakeimg.pl/350", model.avatar)
        assertEquals("Tran Van Nam", model.name)
    }

    @Test
    fun mapCreatedByToEntity() {
        val postModel = createPostModel()
        val jsonCreatedByResult = mapper.mapCreatedByToEntity(postModel.createdBy)

        assertEquals(jsonCreatedBy, jsonCreatedByResult)
    }
    
    @Test 
    fun mapToDomain() {
        val entity = createPostEntity()
        val model = mapper.mapToDomain(entity)

        assertEquals(entity.id, model.id)
        assertEquals(entity.content, model.content)
        assertEquals(entity.createdAt, model.createdAt)
        assertEquals(entity.image, model.image)
    }

    @Test
    fun mapToEntity() {
        val model = createPostModel()
        val entity = mapper.mapToEntity(model)

        assertEquals(model.id, entity.id)
        assertEquals(model.content, entity.content)
        assertEquals(model.createdAt, entity.createdAt)
        assertEquals(model.image, entity.image)

    }

    private fun createPostEntity() = PostEntity(
        "1",
        TestUtil.LOREM_STRING,
        "https://fakeimg.pl/700",
        dateTest,
        jsonCreatedBy
    )

    private fun createPostModel() = Post(
        "1",
        TestUtil.LOREM_STRING,
        "https://fakeimg.pl/700",
        dateTest,
        createCreatedByModel()
    )

    private fun createCreatedByModel() = Post.CreatedBy(
        id = "1",
        avatar = "https://fakeimg.pl/350",
        name = "Tran Van Nam"
    )
}