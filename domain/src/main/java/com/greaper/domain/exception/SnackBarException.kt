package com.greaper.domain.exception

import com.example.cleanarchitecture.domain.exception.CleanException

class SnackBarException(
    override val code: Int,
    override val message: String
) : CleanException(code, ExceptionType.SNACK, message)