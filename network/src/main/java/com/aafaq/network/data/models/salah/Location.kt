package com.aafaq.network.data.models.salah

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Location(
    var latitude: Double? = null,
    var longitude: Double? = null
)
