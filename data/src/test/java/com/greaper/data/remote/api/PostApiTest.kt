package com.greaper.data.remote.api

import com.greaper.data.utils.TestUtil
import com.greaper.data.utils.TestUtil.getJson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import org.junit.Assert.assertEquals
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class PostApiTest : BaseApiTest<PostApi>() {

    override fun apiClass(): Class<PostApi> {
        return PostApi::class.java
    }

    @Test
    fun getPost() = runTest {
        val limit = 10
        val page = 1
        val path = "/posts?page=$page&limit=$limit"
        val mockResponse = MockResponse()
            .setBody(getJson("post/get-post.json"))
        mockServer.enqueue(mockResponse)
        val dto = apiService.getPosts(page, limit)

        val request = mockServer.takeRequest()
        assertEquals(path, request.path)
        assertEquals(1, dto.size)
        assertEquals(
            TestUtil.LOREM_STRING,
            dto.getOrNull(0)?.content
        )
    }

    @Test
    fun getPost_WithEmptyArray() = runTest {
        val limit = 10
        val page = 1
        val path = "/posts?page=$page&limit=$limit"
        val mockResponse = MockResponse()
            .setBody("[]")
        mockServer.enqueue(mockResponse)
        val dto = apiService.getPosts(page, limit)

        // get request to test
        val request = mockServer.takeRequest()
        assertEquals(path, request.path)
        assertEquals(0, dto.size)
    }

    @Test
    fun getPost_WithEmptyObject() = runTest {
        val limit = 10
        val page = 1
        val path = "/posts?page=$page&limit=$limit"
        val mockResponse = MockResponse()
            .setBody("[{}]")
        mockServer.enqueue(mockResponse)
        val dto = apiService.getPosts(page, limit)

        val request = mockServer.takeRequest()
        assertEquals(path, request.path)
        assertEquals(1, dto.size)
        assertEquals(
            null,
            dto.getOrNull(0)?.content
        )

        assertEquals(
            null,
            dto.getOrNull(0)?.id
        )
    }

}