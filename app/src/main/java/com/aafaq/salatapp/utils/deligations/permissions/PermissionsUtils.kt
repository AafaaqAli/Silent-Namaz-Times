package com.aafaq.salatapp.utils.deligations.permissions

import android.Manifest.permission.*

fun getAppPermissions(): ArrayList<String>{
    return arrayListOf(
        REQUEST_IGNORE_BATTERY_OPTIMIZATIONS,
        POST_NOTIFICATIONS,

        RECEIVE_BOOT_COMPLETED,
        ACCESS_FINE_LOCATION,
        ACCESS_COARSE_LOCATION,
        READ_CONTACTS
    )
}