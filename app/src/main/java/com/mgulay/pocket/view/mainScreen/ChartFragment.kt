package com.mgulay.pocket.view.mainScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.mgulay.pocket.R
import com.mgulay.pocket.databinding.FragmentChartBinding
import com.mgulay.pocket.viewmodel.ChartFragmentViewModel

class ChartFragment : Fragment() {
   lateinit var binding:FragmentChartBinding
   lateinit var viewModel:ChartFragmentViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentChartBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProvider(this).get(ChartFragmentViewModel::class.java)
        viewModel.insert(binding.pieChart)

    }

}