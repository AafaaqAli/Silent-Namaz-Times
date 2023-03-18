package com.aafaq.network.data

data class GeneralResponse(
    var code: Int? = null,
    var status: String? = null,
    var data: ArrayList<Any?> = arrayListOf()
)
