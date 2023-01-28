package com.greaper.domain.exception

open class CleanException(
    open val code: Int,
    val exceptionType: ExceptionType,
    override val message: String?
) : Throwable(message)