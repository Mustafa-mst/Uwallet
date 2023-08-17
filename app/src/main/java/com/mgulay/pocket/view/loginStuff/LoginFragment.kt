package com.mgulay.pocket.view.loginStuff

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.mgulay.pocket.databinding.FragmentLoginBinding
import com.mgulay.pocket.view.mainScreen.AppActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class LoginFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: FragmentLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth= FirebaseAuth.getInstance()

        binding.forgotPassword.setOnClickListener {
            val action=LoginFragmentDirections.actionLoginFragmentToForgotFragment()
            Navigation.findNavController(view).navigate(action)
        }

        binding.registerPageText.setOnClickListener {
            goToRegister(it)
        }
        binding.logInButton.setOnClickListener {
            logIn(it)
        }


    }
    fun goToRegister(view:View){
        val action=LoginFragmentDirections.actionLoginFragmentToCreateUserFragment()
        Navigation.findNavController(view).navigate(action)
    }

    fun logIn(view:View){
        var email=binding.emailEditLogin.text.toString().trim()
        var password=binding.passwordEditLogin.text.toString().trim()
        if (!email.isNullOrEmpty()&&!password.isNullOrEmpty()){
            binding.progressLogin.visibility=View.VISIBLE
            binding.groupLogin.visibility=View.GONE
            auth.signInWithEmailAndPassword(email,password).addOnSuccessListener {
                val intent= Intent(context,AppActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
            }.addOnFailureListener {
                binding.progressLogin.visibility=View.GONE
                binding.groupLogin.visibility=View.VISIBLE
                Snackbar.make(view,it.localizedMessage, Snackbar.LENGTH_SHORT).setTextColor(
                    Color.parseColor("#FFFFFF")).setBackgroundTint(Color.parseColor("#2752E7")).show()
            }
        }else{
            Snackbar.make(view,"Lütfen Tüm Alanları Doldurunuz !", Snackbar.LENGTH_SHORT).setTextColor(
                Color.parseColor("#FFFFFF")).setBackgroundTint(Color.parseColor("#2752E7")).show()
        }
    }


}