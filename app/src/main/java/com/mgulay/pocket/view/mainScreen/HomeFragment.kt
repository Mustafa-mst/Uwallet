package com.mgulay.pocket.view.mainScreen

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import androidx.core.view.marginBottom
import androidx.core.view.setPadding
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.mgulay.pocket.R
import com.mgulay.pocket.databinding.FragmentHomeBinding
import com.mgulay.pocket.model.Utils
import com.mgulay.pocket.model.recyclerAdapter
import com.mgulay.pocket.view.loginStuff.MainActivity
import com.mgulay.pocket.viewmodel.HomeFragmentVievModel


open class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseFirestore
    private lateinit var viewModel: HomeFragmentVievModel
    private lateinit var adapter:recyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize(view)

    }


    private fun observeData(){
        viewModel.installmentsText.observe(viewLifecycleOwner){
            if (!it.isNullOrEmpty()){
                binding.installmentsText.text=it

            }
        }
        viewModel.rentPaymentText.observe(viewLifecycleOwner){
            if (!it.isNullOrEmpty()){
                binding.rentPaymentText.text=it

            }
        }
        viewModel.savingsText.observe(viewLifecycleOwner){
            if (!it.isNullOrEmpty()){
                binding.savingsText.text="${it}₺"

            }
        }
        viewModel.totalExtenses.observe(viewLifecycleOwner){
            if (it!=0&&it!=null){
                binding.expensesTotalText.text="-${it}₺"

            }
        }
        viewModel.remaining.observe(viewLifecycleOwner){
            if (it!=0&&it!=null){
                binding.remainingText.text="=${it}₺"
            }
        }
        viewModel.userName.observe(viewLifecycleOwner){
            if (!it.isNullOrEmpty()){
                binding.greetingText.text="Hoşgeldin,${it}"
            }
        }

    }
    private fun initialize(view:View){

        auth = FirebaseAuth.getInstance()
        database= FirebaseFirestore.getInstance()
        viewModel = ViewModelProvider(this).get(HomeFragmentVievModel::class.java)
        viewModel.GetFromFirebase(database,auth)
        adapter= recyclerAdapter(arrayListOf())
        binding.mainRecycler.layoutManager=LinearLayoutManager(view.context)
        binding.mainRecycler.addItemDecoration(DividerItemDecoration(view.context,DividerItemDecoration.VERTICAL))
        binding.mainRecycler.adapter=adapter
        binding.changeSaving.setOnClickListener {
            viewModel.changeTheSavings(it,requireContext(),binding.changeRegularExes,binding.addExpenses,binding.warningText)
        }
        binding.exitButton.setOnClickListener {
            viewModel.exitTheApp(
                it,
                requireContext(),
                auth,
                requireActivity()
            )
        }
        binding.addExpenses.setOnClickListener {
            viewModel.addExpenses(it,adapter)
        }
        binding.changeRegularExes.setOnClickListener { viewModel.changeTheRegularExes(it,requireContext()) }
        observeData()
    }
    }





