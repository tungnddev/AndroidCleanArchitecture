package com.greaper.domain.model

import java.util.*

data class Post(
    var id: String,
    var content: String,
    var image: String,
    var createdAt: Date,
    var createdBy: CreatedBy
) : Model() {
    data class CreatedBy(
        var id: String,
        var name: String,
        var avatar: String
    )
}