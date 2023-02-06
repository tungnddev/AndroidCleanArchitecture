package com.greaper.domain.exception

open class NetworkException(
    override val message: String?
) : CleanException(message) {
    class NoConnection : NetworkException(null)
    class ServerError : NetworkException(null)
    class Error(val code: String?, override val message: String?) : NetworkException(message)
}