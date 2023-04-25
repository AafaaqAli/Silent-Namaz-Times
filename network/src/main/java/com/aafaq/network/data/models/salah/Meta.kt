package com.aafaq.network.data.models.salah

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Meta(
    var latitude: Double? = null,
    var longitude: Double? = null,
    var timezone: String? = null,
    var method: Method? = null,
    var latitudeAdjustmentMethod: String? = null,
    var midnightMode: String? = null,
    var school: String? = null,
    var offset: Offset? = null
)
