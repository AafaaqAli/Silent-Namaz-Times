package com.aafaq.network.data.models.salah

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Date(
    var readable: String? = null,
    var timestamp: String? = null,
    var gregorian: Gregorian? = null,
    var hijri: Hijri? = null
)
