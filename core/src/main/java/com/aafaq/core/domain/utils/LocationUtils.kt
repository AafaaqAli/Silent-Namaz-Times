package com.aafaq.core.domain.utils

import android.content.Context
import com.aafaq.network.data.models.salah.Location

fun Context.getLocation(): Location? {
    try{
        return null
    }catch (e: Exception){
        /**
         * As app is using fused Location which uses google play services
         * it is possible that the app might crash if on any ROM there is no PlayServices
         * */

        e.printStackTrace()
        return null
    }
}