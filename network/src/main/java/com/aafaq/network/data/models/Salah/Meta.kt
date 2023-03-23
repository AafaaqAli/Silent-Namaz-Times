package com.aafaq.network.data.models.Salah

data class Meta(
    var latitude                 : Double? = null,
    var longitude                : Double? = null,
    var timezone                 : String? = null,
    var method                   : Method? = Method(),
    var latitudeAdjustmentMethod : String? = null,
    var midnightMode             : String? = null,
    var school                   : String? = null,
    var offset                   : Offset? = Offset()
)
