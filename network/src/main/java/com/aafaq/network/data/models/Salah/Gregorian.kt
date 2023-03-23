package com.aafaq.network.data.models.Salah

data class Gregorian(
    var date        : String?      = null,
    var format      : String?      = null,
    var day         : String?      = null,
    var weekday     : Weekday?     = Weekday(),
    var month       : Month?       = Month(),
    var year        : String?      = null,
    var designation : Designation? = Designation()
)
