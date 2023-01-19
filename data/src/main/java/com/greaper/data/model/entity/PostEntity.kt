package com.greaper.data.model.entity

import androidx.room.Entity
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.greaper.data.base.ModelEntity
import com.greaper.data.utils.RoomConverters
import java.util.*

@Entity(tableName = "post", primaryKeys = ["id"])
@TypeConverters(RoomConverters::class)
data class PostEntity(
    @SerializedName("id")
    var id: String,
    @SerializedName("title")
    var content: String,
    @SerializedName("image")
    var image: String,
    @SerializedName("created_at")
    var createdAt: Date,
    @SerializedName("created_by")
    var createdBy: String
) : ModelEntity() {
    data class CreatedBy(
        @SerializedName("id")
        var id: String,
        @SerializedName("name")
        var name: String,
        @SerializedName("avatar")
        var avatar: String,
    )
}