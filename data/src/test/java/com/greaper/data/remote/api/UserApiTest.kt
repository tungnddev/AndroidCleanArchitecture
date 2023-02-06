package com.greaper.data.remote.api

import com.greaper.data.utils.TestUtil
import com.greaper.domain.exception.NetworkException
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

    @Test
    fun getUser_With404() = runTest {
        val path = "/user"
        val mockResponse = MockResponse()
            .setResponseCode(404)
            .setBody(TestUtil.getJson("user/get-user-404.json"))
        mockServer.enqueue(mockResponse)
        try {
            val dto = apiService.getUser()

            // cannot go to here, because it will run into catch exception
            assertEquals(false, true)
        } catch (e: Throwable) {
            assertEquals(
                true,
                e is NetworkException.Error && e.code == "USER_NOT_FOUND" && e.message == "User is invalid"
            )
        }
    }

    @Test
    fun getUser_WithTimeout() = runTest {
        try {
            val dto = apiService.getUser()

            // cannot go to here, because it will run into catch exception
            assertEquals(false, true)
        } catch (e: Throwable) {
            assertEquals(
                true,
                e is NetworkException.NoConnection
            )
        }
    }

}