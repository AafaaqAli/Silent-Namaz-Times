package com.aafaq.salatapp.presentation.fragments.profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aafaq.salatapp.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    /**
     * view model
     * */
    private lateinit var viewModel: ProfileViewModel

    /**
     * View Binding
     * */
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        binding.lifecycleOwner = this

        binding.viewModel = this.viewModel

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}