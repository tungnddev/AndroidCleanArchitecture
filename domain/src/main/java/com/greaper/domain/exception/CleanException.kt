package com.greaper.domain.exception

open class CleanException(
    override val message: String?
) : Throwable(message)