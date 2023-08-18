package com.mgulay.pocket.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bumptech.glide.manager.Lifecycle
import com.mgulay.pocket.view.mainScreen.ExchangeFragment
import com.mgulay.pocket.view.mainScreen.ExchangeGold

class ViewPagerAdapter(fragmentManager: FragmentManager,lifecycle:androidx.lifecycle.Lifecycle):FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->ExchangeFragment()
            1->ExchangeGold()
            else->Fragment()
        }
    }
}