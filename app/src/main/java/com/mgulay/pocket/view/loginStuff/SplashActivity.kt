package com.mgulay.pocket.view.loginStuff

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.google.firebase.auth.FirebaseAuth
import com.mgulay.pocket.databinding.ActivitySplashBinding
import com.mgulay.pocket.view.mainScreen.AppActivity


class SplashActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
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