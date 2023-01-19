package com.greaper.domain.exception

import com.example.cleanarchitecture.domain.exception.CleanException

class AlertException(
    override val code: Int,
    override val message: String,
    val title: String? = null
) : CleanException(code, ExceptionType.ALERT, message)