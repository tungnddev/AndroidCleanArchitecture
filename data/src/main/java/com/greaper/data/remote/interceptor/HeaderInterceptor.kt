package com.greaper.data.remote.interceptor

import com.greaper.data.local.pref.PrefHelper
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor(
    var preferHelper: PrefHelper
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val token = preferHelper.getToken()

        val originalRequest = chain.request()
        val newRequest = originalRequest.newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("Accept", "application/json")
            .apply { token?.accessToken?.let { addHeader("Authorization", "Bearer $it") } }
            .build()
        return chain.proceed(newRequest)
    }
}