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
import com.google.firebase.firestore.FirebaseFirestore
import com.mgulay.pocket.R
import com.mgulay.pocket.databinding.FragmentCreateUserBinding

class CreateUserFragment : Fragment() {
private lateinit var binding: FragmentCreateUserBinding
private lateinit var auth:FirebaseAuth
private lateinit var database:FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentCreateUserBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth= FirebaseAuth.getInstance()
        database= FirebaseFirestore.getInstance()
        binding.registerButton.setOnClickListener {
            register(it)
        }

    }

        fun register(view:View){
       var userName=binding.usernameEditCreate.text.toString().trim()
       var email=binding.emailEditCreate.text.toString().trim()
       var password=binding.passwordEditCreate.text.toString()

       if (!userName.isNullOrEmpty()&&!email.isNullOrEmpty()&&!password.isNullOrEmpty()){
           binding.progress.visibility=View.VISIBLE
           binding.groupCreate.visibility=View.GONE
            auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {
                var hashList= hashMapOf<String,Any>("userName" to userName,"userId" to auth.currentUser!!.uid)
                database.collection("Users").add(hashList)
                val action =CreateUserFragmentDirections.actionCreateUserFragmentToLoginFragment(1)
                Navigation.findNavController(view).navigate(action)

            }.addOnFailureListener {
                binding.progress.visibility=View.GONE
                binding.groupCreate.visibility=View.VISIBLE
                Snackbar.make(view,it.localizedMessage,Snackbar.LENGTH_SHORT).show()
            }

       }else{
           Snackbar.make(view,"Lütfen Tüm Alanları Doldurunuz !",Snackbar.LENGTH_SHORT).show()
       }

   }

}