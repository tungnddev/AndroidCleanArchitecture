package com.greaper.data.model.dto

import com.google.gson.annotations.SerializedName
import com.greaper.data.base.ModelDto

data class UserDto(
    @SerializedName("id")
    var id: String?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("country_code")
    var countryCode: String?,
    @SerializedName("avatar")
    var avatar: String?,
) : ModelDto()