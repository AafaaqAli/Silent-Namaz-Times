package com.aafaq.network.data.models.salah

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Gregorian(
    var date: String? = null,
    var format: String? = null,
    var day: String? = null,
    var weekday: Weekday? = Weekday(),
    var month: Month? = Month(),
    var year: String? = null,
    var designation: Designation? = Designation()
)
