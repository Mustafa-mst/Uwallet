package com.mgulay.pocket.view.mainScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView
import com.mgulay.pocket.R
import com.mgulay.pocket.databinding.ActivityAppBinding

class AppActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())
       binding.bottomNavigation.setOnItemSelectedListener {
          when(it.itemId){
            R.id.homePage->{replaceFragment(HomeFragment())
            true
            }
            R.id.chartPage->{replaceFragment(ChartFragment())
            true}
            R.id.exchangePage->{replaceFragment(ExchangeFragment())
            true}
            else ->{}
          }
           true

       }
    }
    private fun replaceFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.container,fragment).commit()
    }
}