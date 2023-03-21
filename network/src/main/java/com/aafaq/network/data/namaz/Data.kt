package com.aafaq.network.data.namaz

data class Data(
    var timings : Timings? = Timings(),
    var date    : Date?    = Date(),
    var meta    : Meta?    = Meta()
)
