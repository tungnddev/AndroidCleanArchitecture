package com.greaper.data.remote.api

import com.greaper.data.local.pref.PrefHelper
import com.greaper.data.model.entity.TokenEntity
import com.greaper.data.remote.builder.RetrofitBuilder
import com.greaper.data.remote.interceptor.HeaderInterceptor
import com.greaper.data.utils.TestUtil
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.mockito.Mockito

abstract class BaseApiTest<T : Any> {
    lateinit var apiService: T
    lateinit var mockServer: MockWebServer

    @Before
    fun setUp() {
        val prefHelper = mockPreHelper()
        val headerInterceptor = HeaderInterceptor(prefHelper)
        val retrofitBuilder = RetrofitBuilder()
        mockServer = MockWebServer()
        apiService = retrofitBuilder
            .setBaseHttpUrl(mockServer.url(""))
            .addInterceptors(headerInterceptor)
            .build()
            .create(apiClass())
    }

    private fun mockPreHelper(): PrefHelper {
        val prefHelper: PrefHelper = Mockito.mock(PrefHelper::class.java)
        Mockito.`when`(prefHelper.getToken())
            .thenReturn(
                TokenEntity(
                    TestUtil.ACCESS_TOKEN,
                    TestUtil.REFRESH_TOKEN,
                )
            )
        return prefHelper
    }

    @After
    fun tearDown() {
        mockServer.shutdown()
    }

    abstract fun apiClass(): Class<T>
}