package com.aafaq.salatapp.presentation.activities.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.aafaq.salatapp.databinding.ActivityDashboardBinding
import com.aafaq.salatapp.utils.deligations.navigation.INavigationHelper
import com.aafaq.salatapp.utils.deligations.navigation.NavigationHelperImp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity(), INavigationHelper by NavigationHelperImp() {
    /**
     * View binding
     * */
    private lateinit var binding: ActivityDashboardBinding

    /**
     * View model
     * */
    val fragmentContainerViewModel: DashboardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lifecycleOwner = this

        /**
         * Init navigation
         * */
        initNavigation(this)
    }
}