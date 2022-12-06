package com.greaper.domain.model

data class User(
    var id: String,
    var name: String,
    var countryCode: String,
) : Model()