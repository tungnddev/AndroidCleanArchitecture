package com.greaper.data.model.entity

import com.google.gson.annotations.SerializedName
import com.greaper.data.base.ModelEntity

data class UserEntity(
    @SerializedName("id")
    var id: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("country_code")
    var countryCode: String,
    @SerializedName("avatar")
    var avatar: String
) : ModelEntity()