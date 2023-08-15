package com.mgulay.pocket.view.mainScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mgulay.pocket.R
import com.mgulay.pocket.databinding.FragmentExchangeBinding
import com.mgulay.pocket.model.DataClass
import com.mgulay.pocket.model.ExchangeVal
import com.mgulay.pocket.model.exchangeAdapter
import com.mgulay.pocket.model.retrofit
import com.mgulay.pocket.viewmodel.ExchangeFragmentViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ExchangeFragment : Fragment() {
    lateinit var binding:FragmentExchangeBinding
    lateinit var exchangeList:ArrayList<ExchangeVal>
    var mustafa:String?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentExchangeBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var viewModel=ViewModelProvider(this).get(ExchangeFragmentViewModel::class.java)
        var adapter=exchangeAdapter(arrayListOf())
        binding.exchangeRcy.layoutManager=LinearLayoutManager(view.context)
        binding.exchangeRcy.adapter=adapter
        binding.exchangeRcy.addItemDecoration(
            DividerItemDecoration(view.context,
                DividerItemDecoration.VERTICAL)
        )
        viewModel.getData(view,adapter,binding.exProgress,binding.exchangeRcy)
    }


}