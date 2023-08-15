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
import android.widget.Toast
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
        binding.exchangeCardView.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container,ExchangeFragment()).commit()
        }
        initialize(view)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.InsertFirebase(database,auth)
    }




    private fun observeData(){
        viewModel.progressBar.observe(viewLifecycleOwner){
            if (it){
            binding.fragmentProgress.visibility=View.VISIBLE
                binding.greetingText.visibility=View.GONE
                binding.warningText.visibility=View.GONE
                binding.mainCardview.visibility=View.GONE
                binding.recyclerCard.visibility=View.GONE
                binding.regularExtenseTitle.visibility=View.GONE
                binding.secondpayment.visibility=View.GONE
                binding.monthlyExes.visibility=View.GONE

            }else{
                binding.fragmentProgress.visibility=View.GONE
                binding.greetingText.visibility=View.VISIBLE
                binding.warningText.visibility=View.VISIBLE
                binding.mainCardview.visibility=View.VISIBLE
                binding.recyclerCard.visibility=View.VISIBLE
                binding.regularExtenseTitle.visibility=View.VISIBLE
                binding.secondpayment.visibility=View.VISIBLE
                binding.monthlyExes.visibility=View.VISIBLE
            }
        }
        viewModel.installmentsText.observe(viewLifecycleOwner){
            if (it!=null){
                binding.installmentsText.text="${it.toString()}₺"
            }
        }
        viewModel.rentPaymentText.observe(viewLifecycleOwner){
            if (it!=null){
                binding.rentPaymentText.text="${it.toString()}₺"

            }
        }
        viewModel.savingsText.observe(viewLifecycleOwner){
            if (it!=null&&it!=0){
                binding.savingsText.text="${it}₺"
                binding.addExpenses.visibility=View.VISIBLE
                binding.changeRegularExes.visibility=View.VISIBLE
                binding.warningText.visibility=View.GONE
            }else{
                binding.savingsText.text="0₺"
                binding.addExpenses.visibility=View.GONE
                binding.changeRegularExes.visibility=View.GONE
                binding.warningText.visibility=View.VISIBLE
            }
        }
        viewModel.totalExtenses.observe(viewLifecycleOwner){
            if (it!=0&&it!=null){
                binding.expensesTotalText.text="-${it}₺"

            }
        }

        viewModel.userName.observe(viewLifecycleOwner){
            if (!it.isNullOrEmpty()){
                var a=it.split(" ")
                binding.greetingText.text="Hoşgeldin,${a.get(0).capitalize()}"
                binding.nameTxt.text=it.capitalize()
            }
        }
        viewModel.isEmpty.observe(viewLifecycleOwner){
            if (!it){
                binding.isEmpty.visibility=View.GONE
                binding.mainRecycler.visibility=View.VISIBLE
            }
        }

    }
    private fun initialize(view:View){
        auth = FirebaseAuth.getInstance()
        database= FirebaseFirestore.getInstance()
        viewModel = ViewModelProvider(this).get(HomeFragmentVievModel::class.java)
        adapter= recyclerAdapter(arrayListOf())
        binding.mainRecycler.adapter=adapter
        viewModel.GetFromFirebase(adapter,view,database,auth)
        binding.mainRecycler.layoutManager=LinearLayoutManager(view.context)
        binding.mainRecycler.addItemDecoration(DividerItemDecoration(view.context,DividerItemDecoration.VERTICAL))
        binding.changeSaving.setOnClickListener {
            viewModel.changeTheSavings(it,requireContext())
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
            viewModel.addExpenses(it,adapter,auth,database)
        }
        binding.changeRegularExes.setOnClickListener { viewModel.changeTheRegularExes(it,requireContext()) }
        observeData()
    }
    }





