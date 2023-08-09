package com.example.foodrecipeapp.screen.settings

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodrecipeapp.databinding.FragmentSettingBinding
import com.example.foodrecipeapp.utils.base.BaseViewBindingFragment

class SettingFragment : BaseViewBindingFragment<FragmentSettingBinding>() {

    override fun createBindingFragment(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSettingBinding {
        return FragmentSettingBinding.inflate(inflater, container, false)
    }

    override fun initView(view: View?) {
//        TODO("Not yet implemented")
    }

    override fun initData() {
//        TODO("Not yet implemented")
    }

    companion object {
        @JvmStatic
        fun newInstance() = SettingFragment()
    }
}
