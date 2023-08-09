package com.example.foodrecipeapp.screen.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodrecipeapp.data.model.Recipe
import com.example.foodrecipeapp.databinding.FragmentHomeBinding
import com.example.foodrecipeapp.listener.OnItemRecyclerViewClickListener
import com.example.foodrecipeapp.utils.base.BaseViewBindingFragment

class HomeFragment : BaseViewBindingFragment<FragmentHomeBinding>(), OnItemRecyclerViewClickListener<Recipe> {
    override fun createBindingFragment(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun initView(view: View?) {
//        TODO("Not yet implemented")
    }

    override fun initData() {
//        TODO("Not yet implemented")
    }

    override fun onItemClick(item: Recipe?) {
//        TODO("Not yet implemented")
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}
