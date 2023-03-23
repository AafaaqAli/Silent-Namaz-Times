package com.aafaq.salatapp.presentation.fragments.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aafaq.salatapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}