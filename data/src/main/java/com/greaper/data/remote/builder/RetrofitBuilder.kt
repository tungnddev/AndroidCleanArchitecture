package com.greaper.data.remote.builder

import com.greaper.data.BuildConfig
import com.greaper.data.HttpClient
import com.greaper.data.remote.factory.NetworkResponseAdapterFactory
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitBuilder @Inject constructor() {
    private var interceptors = mutableListOf<Interceptor>()
    private var baseHttpUrl = BuildConfig.API_ENDPOINT.toHttpUrl()

    /**
     * add custom interceptor for ok http client
     * @param interceptor is a interceptor for ok http client
     */
    fun addInterceptors(vararg interceptor: Interceptor): RetrofitBuilder {
        interceptors.addAll(interceptor)
        return this
    }

    fun setBaseHttpUrl(baseHttpUrl: HttpUrl): RetrofitBuilder {
        this.baseHttpUrl = baseHttpUrl
        return this
    }


    fun setBaseUrl(url: String): RetrofitBuilder {
        this.baseHttpUrl = url.toHttpUrl()
        return this
    }

    /**
     * Make a Retrofit
     */
    fun build(): Retrofit {
        val clientBuilder = OkHttpClient.Builder().apply {
            connectTimeout(HttpClient.CONNECT_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(HttpClient.WRITE_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(HttpClient.READ_TIMEOUT, TimeUnit.SECONDS)

            if (BuildConfig.DEBUG) {
                addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
            }

            interceptors.forEach { addInterceptor(it) }
        }

        return Retrofit.Builder()
            .baseUrl(baseHttpUrl)
            .client(clientBuilder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .build()
    }
}