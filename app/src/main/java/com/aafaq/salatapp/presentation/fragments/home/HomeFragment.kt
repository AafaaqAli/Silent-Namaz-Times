package com.aafaq.salatapp.presentation.fragments.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.aafaq.network.data.models.salah.Data
import com.aafaq.salatapp.databinding.FragmentHomeBinding
import com.aafaq.salatapp.presentation.views.SalahTimeClickListener

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

        initSalahTimeView()
    }

    private fun initSalahTimeView(){
        binding.salahTimeView.setSalahMenuItems(
         arrayListOf(
             Data(

             ),
             Data(

             ),

             Data(

             ),

             Data(

             ),

             Data(

             ),
         )
        ,salahTimeClickListener = object : SalahTimeClickListener{
            override fun onItemClicked(item: Data, position: Int) {
                Toast.makeText(requireContext(), "Click On Position: $position", Toast.LENGTH_SHORT).show()
            }

            override fun onItemLongClicked(item: Data, position: Int) {
                Toast.makeText(requireContext(), "LongClick On Position: $position", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}