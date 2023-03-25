package com.aafaq.network.data.models.salah

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Weekday(
    var en: String? = null,
    var ar: String? = null
)
