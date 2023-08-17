package com.mgulay.pocket.view.loginStuff

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.mgulay.pocket.R
import com.mgulay.pocket.databinding.ActivitySplashBinding
import com.mgulay.pocket.view.mainScreen.AppActivity

class SplashActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth= FirebaseAuth.getInstance()
        Handler(Looper.myLooper()!!).postDelayed({
            Decide()
        },1000)

    }
    private fun Decide(){
        if (auth.currentUser!=null){
            val intent = Intent(this, AppActivity::class.java)
            startActivity(intent)
            finish()
        }else{
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}