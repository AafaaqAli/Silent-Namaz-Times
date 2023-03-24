package com.aafaq.network.data.models.salah

data class Method(
    var id       : Int?      = null,
    var name     : String?   = null,
    var params   : Params?   = Params(),
    var location : Location? = Location()
)
