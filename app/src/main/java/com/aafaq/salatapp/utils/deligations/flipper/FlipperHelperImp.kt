package com.aafaq.salatapp.utils.deligations.flipper

import android.app.Application
import com.aafaq.salatapp.BuildConfig
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.crashreporter.CrashReporterPlugin
import com.facebook.flipper.plugins.databases.DatabasesFlipperPlugin
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.navigation.NavigationFlipperPlugin
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.facebook.flipper.plugins.sharedpreferences.SharedPreferencesFlipperPlugin
import com.facebook.litho.config.ComponentsConfiguration
import com.facebook.litho.editor.flipper.LithoFlipperDescriptors
import com.facebook.soloader.SoLoader



class FlipperHelperImp: IFlipperHelper {
    lateinit var application: Application

    private val client by lazy {
        AndroidFlipperClient.getInstance(application)
    }

    override fun initFlipper(application: Application) {
        this.application = application
        SoLoader.init(this.application, false)



        if(BuildConfig.DEBUG){
            val client = AndroidFlipperClient.getInstance(application)

            /**
             * Add plugins
             * */
            addPlugins()

            /**
             * Start Client
             * */
            client.start()
        }
    }




    private val networkFlipperPlugin = NetworkFlipperPlugin()

    private fun addPlugins(){
        client.apply {
            //crash reporting inspector
            addPlugin(CrashReporterPlugin.getInstance())

            //database inspector
            addPlugin(DatabasesFlipperPlugin(application))

            //navigation inspector
            addPlugin(NavigationFlipperPlugin.getInstance())

            //sharedPreference Inspector
            addPlugin(SharedPreferencesFlipperPlugin(application, "com.aafaq.salatapp.prefs"))

            //network inspector
            addPlugin(networkFlipperPlugin)

            //layout inspector
            ComponentsConfiguration.isDebugModeEnabled = true;
            LithoFlipperDescriptors.add(DescriptorMapping.withDefaults())
            addPlugin(InspectorFlipperPlugin(application, DescriptorMapping.withDefaults()))
        }
    }
}