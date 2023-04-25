package com.aafaq.network.data.models.salah

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data(
    var timings: Timings? = null,
    var date: Date? = null,
    var meta: Meta? = null
)
