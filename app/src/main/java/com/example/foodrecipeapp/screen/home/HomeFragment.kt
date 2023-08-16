package com.example.foodrecipeapp.screen.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.example.foodrecipeapp.adapter.HomeChildAdapter
import com.example.foodrecipeapp.data.model.HomeChild
import com.example.foodrecipeapp.data.model.Recipe
import com.example.foodrecipeapp.data.repo.RecipeRepo
import com.example.foodrecipeapp.data.repo.source.remote.RecipeRemoteDataSource
import com.example.foodrecipeapp.databinding.FragmentHomeBinding
import com.example.foodrecipeapp.listener.OnItemRecyclerViewClickListener
import com.example.foodrecipeapp.utils.base.BaseViewBindingFragment

class HomeFragment :
    BaseViewBindingFragment<FragmentHomeBinding>(),
    HomeContract.View,
    OnItemRecyclerViewClickListener<Recipe> {
    private lateinit var homePresenter: HomePresenter

    private val homeChildAdapter: HomeChildAdapter by lazy {
        HomeChildAdapter()
    }

    override fun createBindingFragment(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        homeChildAdapter.setData(getListHomeChild())
        binding.rcvHomeParent.adapter = homeChildAdapter
    }

    override fun initData() {
        homePresenter = HomePresenter(
            RecipeRepo.getInstanceRecipeRemoteRepo(RecipeRemoteDataSource.getInstance())
        )
        homePresenter.setView(this)
        homePresenter.getRecipes()
    }

    override fun onItemClick(item: Recipe?) {
        // TODO("Not yet implemented")
    }

    override fun onGetRecipesSuccess(listRecipes: MutableList<Any>) {
        // TODO("Not yet implemented")
    }

    override fun onError(exception: Exception?) {
        Toast.makeText(context, exception?.message, Toast.LENGTH_SHORT).show()
    }

    private fun getListHomeChild(): MutableList<HomeChild> {
        return mutableListOf(
            HomeChild(HomeChildAdapter.HOME_SEARCH_VIEW),
            HomeChild(HomeChildAdapter.HOME_POPULAR_CATEGORY_VIEW),
            HomeChild(HomeChildAdapter.HOME_RECENT_RECIPE_VIEW)
        )
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}
