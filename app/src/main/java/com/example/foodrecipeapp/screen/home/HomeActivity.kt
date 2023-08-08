package com.example.foodrecipeapp.screen.home

import android.os.Bundle
import com.example.foodrecipeapp.databinding.ActivityHomeBinding
import com.example.foodrecipeapp.utils.base.BaseViewBindingActivity

class HomeActivity : BaseViewBindingActivity<ActivityHomeBinding>() {
    override fun createBinding(): ActivityHomeBinding {
        return ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun initView() {
//        TODO("Not yet implemented")
    }

    override fun initData() {
//        TODO("Not yet implemented")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
