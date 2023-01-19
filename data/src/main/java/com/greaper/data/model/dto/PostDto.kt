package com.greaper.data.model.dto

import com.google.gson.annotations.SerializedName
import com.greaper.data.base.ModelDto
import java.util.*

data class PostDto(
    @SerializedName("id")
    var id: String?,
    @SerializedName("title")
    var content: String?,
    @SerializedName("image")
    var image: String?,
    @SerializedName("created_at")
    var createdAt: String?,
    @SerializedName("created_by")
    var createdBy: CreatedBy?
) : ModelDto() {
    data class CreatedBy(
        @SerializedName("avatar")
        var avatar: String?,
        @SerializedName("id")
        var id: String?,
        @SerializedName("name")
        var name: String?
    )
}