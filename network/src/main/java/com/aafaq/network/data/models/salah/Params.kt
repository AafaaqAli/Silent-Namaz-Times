package com.aafaq.network.data.models.salah

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Params(
    var Fajr: Int? = null,
    var Isha: Int? = null
)
