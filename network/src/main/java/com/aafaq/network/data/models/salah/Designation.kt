package com.aafaq.network.data.models.salah

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Designation(
    var abbreviated: String? = null,
    var expanded: String? = null
)
