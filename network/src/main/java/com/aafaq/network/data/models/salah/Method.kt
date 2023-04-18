package com.aafaq.network.data.models.salah

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Method(
    var id: Int? = null,
    var name: String? = null,
    var params: Params? = Params(),
    var location: Location? = Location()
)
