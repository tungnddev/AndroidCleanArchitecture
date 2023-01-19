package com.example.cleanarchitecture.domain.exception

import com.greaper.domain.exception.ExceptionType

open class CleanException(
    open val code: Int,
    val exceptionType: ExceptionType,
    override val message: String?
) : Throwable(message)