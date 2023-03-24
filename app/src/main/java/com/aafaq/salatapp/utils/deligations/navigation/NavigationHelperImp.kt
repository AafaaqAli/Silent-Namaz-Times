package com.aafaq.salatapp.utils.deligations.navigation

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.aafaq.salatapp.R


class NavigationHelperImp: INavigationHelper {
    lateinit var activity: AppCompatActivity

    private val navController by lazy {
        val navHostFragment = activity.supportFragmentManager.findFragmentById(R.id.dashboard_fragment_container) as NavHostFragment
        navHostFragment.navController
    }

    /**
     * Init navController
     * */
    override fun initNavigation(appCompatActivity: AppCompatActivity) {
        this.activity = appCompatActivity
    }

    /**
     * In future app might expand and needs to have more than one
     * navigation features and there should be only one entry/exit point
     * */
    override fun navigateTo(navigation: Navigation?) {
        try{
            when(navigation){
                Navigation.HOME -> navController.navigate(R.id.homeFragment)
                Navigation.SETTING -> navController.navigate(R.id.settingFragment)
                else -> navController.navigate(R.id.homeFragment)
            }
        }catch (e: java.lang.Exception){
            e.printStackTrace()
        }
    }
}

enum class Navigation{
    HOME(),
    SETTING(),
}