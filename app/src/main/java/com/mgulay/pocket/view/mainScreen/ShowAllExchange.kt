package com.mgulay.pocket.view.mainScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.mgulay.pocket.R
import com.mgulay.pocket.adapter.ViewPagerAdapter
import com.mgulay.pocket.databinding.FragmentShowAllExchangeBinding

class ShowAllExchange : Fragment() {
    lateinit var binding:FragmentShowAllExchangeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentShowAllExchangeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter=ViewPagerAdapter(requireActivity().supportFragmentManager,requireActivity().lifecycle)
        binding.viewPager.adapter=adapter
        TabLayoutMediator(binding.tabLayout,binding.viewPager){tab,position->
            when(position){
                0->tab.text="Döviz"
                1->tab.text="Kıymetli Maden"
            }

        }.attach()



    }

}