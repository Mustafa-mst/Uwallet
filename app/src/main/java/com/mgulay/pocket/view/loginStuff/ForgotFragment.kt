package com.mgulay.pocket.view.loginStuff

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.mgulay.pocket.R
import com.mgulay.pocket.databinding.FragmentForgotBinding

class ForgotFragment : Fragment() {
  lateinit var binding:FragmentForgotBinding
  lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentForgotBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth= FirebaseAuth.getInstance()
        binding.sendCodeBtn.setOnClickListener {
            checkEmail(it)
        }

    }
    fun checkEmail(view:View){
        var email=binding.forgotEmailValue.text.toString().trim()
        if (!email.isNullOrEmpty()){auth.sendPasswordResetEmail(email).addOnSuccessListener {
            Snackbar.make(view,"Kod e-postanıza gönderildi",Snackbar.LENGTH_SHORT).setTextColor(
                Color.parseColor("#FFFFFF")).setBackgroundTint(Color.parseColor("#2752E7")).show()
            val action=ForgotFragmentDirections.actionForgotFragmentToLoginFragment()
            Navigation.findNavController(view).navigate(action)
        }.addOnFailureListener {
            Snackbar.make(view,it.localizedMessage,Snackbar.LENGTH_SHORT).setTextColor(
                Color.parseColor("#FFFFFF")).setBackgroundTint(Color.parseColor("#2752E7")).show()
        }
        }else{
            Snackbar.make(view,"Lütfen e-postanızı yazınız",Snackbar.LENGTH_SHORT).setTextColor(
                Color.parseColor("#FFFFFF")).setBackgroundTint(Color.parseColor("#2752E7")).show()
        }

    }

}