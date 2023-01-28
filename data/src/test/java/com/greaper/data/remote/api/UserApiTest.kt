package com.greaper.data.remote.api

import com.greaper.data.utils.TestUtil
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import org.junit.Assert.*
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class UserApiTest : BaseApiTest<UserApi>() {
    override fun apiClass(): Class<UserApi> {
        return UserApi::class.java
    }

    @Test
    fun getUser() = runTest {
        val path = "/user"
        val mockResponse = MockResponse()
            .setBody(TestUtil.getJson("user/get-user.json"))
        mockServer.enqueue(mockResponse)
        val dto = apiService.getUser()

        val request = mockServer.takeRequest()
        assertEquals(path, request.path)
        assertEquals("GET", request.method)
        assertEquals("1", dto.id)
        assertEquals("Tran Van Nam", dto.name)
        assertEquals("VN", dto.countryCode)
        assertEquals("https://fakeimg.pl/700", dto.avatar)
    }

}