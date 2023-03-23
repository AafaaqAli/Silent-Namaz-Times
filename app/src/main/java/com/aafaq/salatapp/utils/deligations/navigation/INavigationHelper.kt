package com.aafaq.salatapp.utils.deligations.navigation

import androidx.appcompat.app.AppCompatActivity
import com.aafaq.core.data.models.Navigation

interface INavigationHelper {
    fun navigateTo(navigation: Navigation?)
    fun initNavigation(appCompatActivity: AppCompatActivity)
}