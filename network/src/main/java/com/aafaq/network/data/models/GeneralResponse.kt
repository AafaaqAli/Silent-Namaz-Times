package com.aafaq.network.data.models

import com.aafaq.network.data.models.salah.Data
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GeneralResponse(
    var code: Int? = null,
    var status: String? = null,
    var data: List<Data> = listOf()
)
