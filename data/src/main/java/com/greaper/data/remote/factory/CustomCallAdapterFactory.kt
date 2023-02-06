package com.greaper.data.remote.factory

import com.greaper.data.model.dto.ErrorDto
import com.greaper.domain.exception.CleanException
import com.greaper.domain.exception.NetworkException
import okhttp3.Request
import okhttp3.ResponseBody
import okio.Timeout
import retrofit2.*
import java.io.IOException
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.util.*
import java.util.concurrent.Executor

class CustomCallAdapterFactory :
    CallAdapter.Factory() {
    override fun get(
        returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit
    ): CallAdapter<*, *>? {
        if (getRawType(returnType) != Call::class.java) {
            return null
        }
        require(returnType is ParameterizedType) { "Call return type must be parameterized as Call<Foo> or Call<? extends Foo>" }
        val responseType = getParameterUpperBound(0, returnType)
        val errorBodyConverter =
            retrofit.nextResponseBodyConverter<ErrorDto>(null, ErrorDto::class.java, annotations)

        return object : CallAdapter<Any, Call<*>> {
            override fun responseType(): Type {
                return responseType
            }

            override fun adapt(call: Call<Any>): Call<Any> {
                return ExecutorCallbackCall(call, errorBodyConverter)
            }
        }
    }

    internal class ExecutorCallbackCall<T>(
        val delegate: Call<T>,
        private val errorBodyConverter: Converter<ResponseBody, ErrorDto>
    ) :
        Call<T> {
        override fun enqueue(callback: Callback<T>) {
            delegate.enqueue(
                object : Callback<T> {
                    override fun onResponse(call: Call<T>, response: Response<T>) {
                        if (delegate.isCanceled) {
                            callback.onFailure(
                                this@ExecutorCallbackCall,
                                NetworkException.ServerError()
                            )
                        } else {

                            if (!response.isSuccessful) {
                                callback.onFailure(
                                    this@ExecutorCallbackCall,
                                    parseUnsuccessfulResponse(response, errorBodyConverter)
                                )
                            } else {
                                callback.onResponse(this@ExecutorCallbackCall, response)
                            }
                        }
                    }

                    override fun onFailure(call: Call<T>, t: Throwable) {
                        callback.onFailure(
                            this@ExecutorCallbackCall,
                            t.asNetworkResponse(errorBodyConverter)
                        )
                    }
                })
        }

        override fun isExecuted(): Boolean {
            return delegate.isExecuted
        }

        @Throws(IOException::class)
        override fun execute(): Response<T> {
            return delegate.execute()
        }

        override fun cancel() {
            delegate.cancel()
        }

        override fun isCanceled(): Boolean {
            return delegate.isCanceled
        }

        override fun clone(): Call<T> {
            return ExecutorCallbackCall(delegate.clone(), errorBodyConverter)
        }

        override fun request(): Request {
            return delegate.request()
        }

        override fun timeout(): Timeout {
            return delegate.timeout()
        }

        private fun parseUnsuccessfulResponse(
            response: Response<*>,
            errorConverter: Converter<ResponseBody, ErrorDto>,
        ): CleanException {
            val errorBody: ResponseBody =
                response.errorBody() ?: return NetworkException.ServerError()

            return try {
                val convertedBody = errorConverter.convert(errorBody)
                NetworkException.Error(convertedBody?.code, convertedBody?.message)
            } catch (error: Throwable) {
                NetworkException.ServerError()
            }
        }

        internal fun Throwable.asNetworkResponse(
            errorConverter: Converter<ResponseBody, ErrorDto>,
        ): CleanException {
            return when (this) {
                is IOException -> NetworkException.NoConnection()
                is HttpException -> {
                    val response = response()
                    if (response == null) {
                        NetworkException.ServerError()
                    } else {
                        parseUnsuccessfulResponse(response, errorConverter)
                    }
                }
                else -> NetworkException.ServerError()
            }
        }
    }


}