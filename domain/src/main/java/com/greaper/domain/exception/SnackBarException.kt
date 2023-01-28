package com.greaper.domain.exception

class SnackBarException(
    override val code: Int,
    override val message: String
) : CleanException(code, ExceptionType.SNACK, message)