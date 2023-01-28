package com.greaper.data.remote.factory

import com.greaper.data.model.dto.ErrorDto

typealias RetrofitResponse<S> = NetworkResponse<S, ErrorDto>