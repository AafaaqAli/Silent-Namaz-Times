package com.aafaq.network.data.namaz

data class Method(
    var id       : Int?      = null,
    var name     : String?   = null,
    var params   : Params?   = Params(),
    var location : Location? = Location()
)
