package com.aafaq.network.data.models

import com.aafaq.network.data.models.salah.Data
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GeneralResponse(
    var code: Int? = null,
    var status: String? = null,

    /**
     * Create a moshi manual parser, because in some APIs like getTimeByCity
     * returns only Data, where the app crashes
     * */
    var data: List<Data> = listOf()
)
