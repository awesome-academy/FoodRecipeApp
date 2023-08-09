package com.example.foodrecipeapp.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.foodrecipeapp.R
import com.example.foodrecipeapp.adapter.MainPageAdapter
import com.example.foodrecipeapp.databinding.ActivityMainBinding
import com.example.foodrecipeapp.screen.favourites.FavouriteFragment
import com.example.foodrecipeapp.screen.home.HomeFragment
import com.example.foodrecipeapp.screen.settings.SettingFragment
import com.example.foodrecipeapp.utils.base.BaseViewBindingActivity

class MainActivity : BaseViewBindingActivity<ActivityMainBinding>() {

    override fun createBindingActivity(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView() {
        val pagerAdapter = MainPageAdapter(this, getFragmentList())
        binding.viewPager.adapter = pagerAdapter
    }

    override fun initData() {
//        TODO("Not yet implemented")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_home -> binding.viewPager.currentItem = 0
                R.id.action_favourite -> binding.viewPager.currentItem = 1
                R.id.action_setting -> binding.viewPager.currentItem = 2
            }

            return@setOnItemSelectedListener true
        }
    }

    private fun getFragmentList(): List<Fragment> {
        return listOf(
            HomeFragment.newInstance(),
            FavouriteFragment.newInstance(),
            SettingFragment.newInstance()
        )
    }
}
