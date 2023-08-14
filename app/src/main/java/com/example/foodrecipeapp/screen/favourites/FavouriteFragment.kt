package com.example.foodrecipeapp.screen.favourites

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.foodrecipeapp.data.model.Recipe
import com.example.foodrecipeapp.databinding.FragmentFavouriteBinding
import com.example.foodrecipeapp.listener.OnItemRecyclerViewClickListener
import com.example.foodrecipeapp.utils.base.BaseViewBindingFragment

class FavouriteFragment : BaseViewBindingFragment<FragmentFavouriteBinding>(), OnItemRecyclerViewClickListener<Recipe> {
    override fun createBindingFragment(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFavouriteBinding {
        return FragmentFavouriteBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        // TODO("Not yet implemented")
    }

    override fun initData() {
        // TODO("Not yet implemented")
    }

    override fun onItemClick(item: Recipe?) {
        // TODO("Not yet implemented")
    }

    companion object {
        @JvmStatic
        fun newInstance() = FavouriteFragment()
    }
}
