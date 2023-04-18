package com.aafaq.salatapp.utils.deligations.permissions

import androidx.appcompat.app.AppCompatActivity


interface IPermissionHelper {
    fun requestPermissions(activity: AppCompatActivity): Boolean
}