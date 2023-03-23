package com.aafaq.network.data.models.Salah

data class Date(
    var readable  : String?    = null,
    var timestamp : String?    = null,
    var gregorian : Gregorian? = Gregorian(),
    var hijri     : Hijri?     = Hijri()
)
