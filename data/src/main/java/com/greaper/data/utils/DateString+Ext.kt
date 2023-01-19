package com.greaper.data.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun String?.toDateOrNull() : Date? {
    if (this == null) return null
    val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
    formatter.timeZone = TimeZone.getTimeZone("UTC")
    return try {
        formatter.parse(this)
    } catch (exception: ParseException) {
        null
    }

}

fun String?.toDate(defaultDate: Date = Date()) : Date {
    return this.toDateOrNull() ?: defaultDate
}