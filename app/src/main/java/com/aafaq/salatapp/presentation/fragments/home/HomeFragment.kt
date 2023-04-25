package com.aafaq.salatapp.presentation.fragments.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.aafaq.core.data.models.UIState
import com.aafaq.network.data.models.salah.Data
import com.aafaq.salatapp.databinding.FragmentHomeBinding
import com.aafaq.salatapp.presentation.views.SalahTimeClickListener
import com.aafaq.salatapp.utils.deligations.navigation.INavigationHelper
import com.aafaq.salatapp.utils.deligations.navigation.NavigationHelperImp
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class HomeFragment: Fragment(), INavigationHelper by NavigationHelperImp() {

    /**
     * view model
     * */
    private lateinit var viewModel: HomeViewModel

    /**
     * View Binding
     * */
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        binding.lifecycleOwner = this

        binding.viewModel = this.viewModel

        handleUiState()
        initViews()

    }

    private fun initViews(){
        viewModel.getCalender()
    }

    private fun handleUiState() {
        lifecycleScope.launch {
            viewModel.homeStateFlow.collectLatest{ state ->
                when (state) {
                    is UIState.Empty -> {
                        binding.swipeRefreshLayout.isRefreshing = false
                        binding.viewClickController.isVisible = false
                    }

                    is UIState.Loading -> {
                        binding.swipeRefreshLayout.isRefreshing = true
                        binding.viewClickController.isVisible = true
                    }

                    is UIState.Success -> {
                        binding.swipeRefreshLayout.isRefreshing = false
                        binding.viewClickController.isVisible = false

                        state.response?.data?.let {
                            initSalahTimeView(it)
                        }
                    }

                    is UIState.Error -> {
                        binding.swipeRefreshLayout.isRefreshing = false
                        binding.viewClickController.isVisible = false
                    }
                }
            }
        }
    }

    private fun initSalahTimeView(listOfData: List<Data>) {
        binding.salahTimeView.setSalahMenuItems(
            listOfData, salahTimeClickListener = object : SalahTimeClickListener {
                override fun onItemClicked(item: Data, position: Int) {
                    Toast.makeText(requireContext(), "Click On Position: $position", Toast.LENGTH_SHORT).show()
                }

                override fun onItemLongClicked(item: Data, position: Int) {
                    Toast.makeText(
                        requireContext(),
                        "LongClick On Position: $position",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}