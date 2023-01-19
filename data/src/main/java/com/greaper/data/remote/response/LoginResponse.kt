package com.greaper.data.remote.response

import com.google.gson.annotations.SerializedName
import com.greaper.data.model.dto.UserDto

data class LoginResponse(
    @SerializedName("access_token")
    var accessToken: String,
    @SerializedName("user")
    var user: UserDto
)