package com.greaper.data.model.dto

import com.google.gson.annotations.SerializedName
import com.greaper.data.base.ModelDto

data class ErrorDto(
    @SerializedName("code")
    val code: String,
    @SerializedName("message")
    val message: String
) : ModelDto()