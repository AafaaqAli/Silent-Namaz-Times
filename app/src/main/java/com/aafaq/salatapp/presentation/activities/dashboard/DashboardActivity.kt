package com.aafaq.salatapp.presentation.activities.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.aafaq.salatapp.databinding.ActivityDashboardBinding
import com.aafaq.salatapp.utils.deligations.location.ILocationHelper
import com.aafaq.salatapp.utils.deligations.location.LocationHelperImp
import com.aafaq.salatapp.utils.deligations.navigation.INavigationHelper
import com.aafaq.salatapp.utils.deligations.navigation.NavigationHelperImp
import com.aafaq.salatapp.utils.deligations.permissions.IPermissionHelper
import com.aafaq.salatapp.utils.deligations.permissions.PermissionHelperImp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity(), IPermissionHelper by PermissionHelperImp(),
    INavigationHelper by NavigationHelperImp() {
    /**
     * View binding
     * */
    private lateinit var binding: ActivityDashboardBinding

    /**
     * View model
     * */
    private val fragmentContainerViewModel: DashboardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lifecycleOwner = this
        binding.viewModel = this.fragmentContainerViewModel


        /**
         * Init navigation
         * */
        initNavigation(this)

        /**
         * Requests Permissions from user through delegate
         * */
        requestPermissions(this)
    }
}