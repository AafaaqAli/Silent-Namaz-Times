package com.aafaq

import android.app.Application
import com.aafaq.salatapp.utils.deligations.flipper.FlipperHelperImp
import com.aafaq.salatapp.utils.deligations.flipper.IFlipperHelper
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ApplicationClass: Application(), IFlipperHelper by FlipperHelperImp() {
    override fun onCreate() {
        super.onCreate()

        /**
         * Initiate Flipper
         * */
        initFlipper(this)
    }
}