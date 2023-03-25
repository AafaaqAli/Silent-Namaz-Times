package com.aafaq.salatapp.utils.deligations.location

import android.location.Location

interface ILocationHelper {
    fun getLocation(): Location
    fun getAddress(): String
    fun getCity(): String
}