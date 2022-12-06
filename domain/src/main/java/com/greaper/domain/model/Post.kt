package com.greaper.domain.model

import java.util.*

data class Post(
    var title: String,
    var body: String,
    var image: String,
    var createdAt: Date
) : Model()