package com.greaper.data.model.entity

import com.google.gson.annotations.SerializedName
import com.greaper.data.base.ModelEntity

data class TokenEntity(
    @SerializedName("access_token")
    var accessToken: String,
    @SerializedName("refresh_token")
    var refreshToken: String,
) : ModelEntity()