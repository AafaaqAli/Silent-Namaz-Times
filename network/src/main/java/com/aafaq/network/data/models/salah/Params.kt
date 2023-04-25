package com.aafaq.network.data.models.salah

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Params(
    /**
     * TODO fix this
     * */
    var Fajr: Int? = null,
    var Isha: Int? = null,
    val Maghrib: Int? = null,
    val Midnight: String? = null
)
