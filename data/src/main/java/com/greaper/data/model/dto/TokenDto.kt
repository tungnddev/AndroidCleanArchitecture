package com.greaper.data.model.dto

import com.google.gson.annotations.SerializedName
import com.greaper.data.base.ModelDto

data class TokenDto(
    @SerializedName("access_token")
    var accessToken: String?,
    @SerializedName("refresh_token")
    var refreshToken: String?,
) : ModelDto()