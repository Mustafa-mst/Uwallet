package com.mgulay.pocket.view.mainScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mgulay.pocket.R
import com.mgulay.pocket.adapter.ExchangeValuableAdapter
import com.mgulay.pocket.adapter.exchangeAdapter
import com.mgulay.pocket.databinding.FragmentExchangeGoldBinding
import com.mgulay.pocket.viewmodel.ExchangeFragmentViewModel
import com.mgulay.pocket.viewmodel.ExchangeGoldViewModel

class ExchangeGold : Fragment() {
    lateinit var binding:FragmentExchangeGoldBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentExchangeGoldBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var viewModel= ViewModelProvider(this).get(ExchangeGoldViewModel::class.java)
        var adapter= ExchangeValuableAdapter(arrayListOf())
        binding.exchangeRcy.layoutManager= LinearLayoutManager(view.context)
        binding.exchangeRcy.adapter=adapter
        binding.exchangeRcy.addItemDecoration(
            DividerItemDecoration(view.context,
                DividerItemDecoration.VERTICAL)
        )
        viewModel.getValuableMaterials(view,binding.exProgress,binding.exchangeRcy,adapter)
    }

}