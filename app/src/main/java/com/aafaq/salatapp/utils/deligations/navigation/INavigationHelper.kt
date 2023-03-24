package com.aafaq.salatapp.utils.deligations.navigation

import androidx.appcompat.app.AppCompatActivity

interface INavigationHelper {
    fun navigateTo(navigation: Navigation?)
    fun initNavigation(appCompatActivity: AppCompatActivity)
}