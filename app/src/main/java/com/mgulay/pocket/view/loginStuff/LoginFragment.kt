package com.mgulay.pocket.view.loginStuff

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.mgulay.pocket.databinding.FragmentLoginBinding

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
        auth?.currentUser.let {
           val action=LoginFragmentDirections.ac
        }

    }


}