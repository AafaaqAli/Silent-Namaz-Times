package com.aafaq.network.data.models.salah

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data(
    var timings: Timings? = Timings(),
    var date: Date? = Date(),
    var meta: Meta? = Meta()
)
