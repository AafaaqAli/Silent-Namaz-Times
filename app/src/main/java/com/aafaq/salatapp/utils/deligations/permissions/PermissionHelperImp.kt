package com.aafaq.salatapp.utils.deligations.permissions

import androidx.appcompat.app.AppCompatActivity

class PermissionHelperImp: IPermissionHelper {
    private val permissions by lazy {
       getAppPermissions()
    }

    override fun requestPermissions(activity: AppCompatActivity): Boolean {
        return true
    }
}