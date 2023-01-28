package com.greaper.data.remote.api

import com.google.gson.Gson
import com.greaper.data.remote.factory.NetworkResponse
import com.greaper.data.utils.TestUtil
import com.greaper.domain.model.LoginUser
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import org.junit.Assert.*
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class AuthApiTest : BaseApiTest<AuthApi>() {

    override fun apiClass(): Class<AuthApi> {
        return AuthApi::class.java
    }

    @Test
    fun login() = runTest {
        val email = "name@abc.com"
        val password = "123456"
        val path = "/login"
        val mockResponse = MockResponse()
            .setBody(TestUtil.getJson("auth/login.json"))
        mockServer.enqueue(mockResponse)
        val response = apiService.login(LoginUser(email, password))

        val request = mockServer.takeRequest()
        val body = Gson().fromJson(request.body.readUtf8(), MutableMap::class.java)
        assertEquals(path, request.path)
        assertEquals("POST", request.method)
        assertEquals(email, body["email"])
        assertEquals(password, body["password"])
        assertEquals(true, response is NetworkResponse.Success)
        assertEquals(TestUtil.ACCESS_TOKEN, (response as NetworkResponse.Success).body.accessToken)
//        assertEquals(TestUtil.REFRESH_TOKEN, dto.refreshToken)
//        when(response) {
//            is NetworkResponse.NetworkError -> {
//
//            }
//            is NetworkResponse.ServerError -> {
//
//            }
//            is NetworkResponse.UnknownError -> {
//
//            }
//            is NetworkResponse.Success -> {
//                response.body
//            }
//        }

//        assertEquals(TestUtil.ACCESS_TOKEN, dto.accessToken)
//        assertEquals(TestUtil.REFRESH_TOKEN, dto.refreshToken)
    }

}