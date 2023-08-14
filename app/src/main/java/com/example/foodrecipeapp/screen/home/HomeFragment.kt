package com.example.foodrecipeapp.screen.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.example.foodrecipeapp.adapter.HomeAdapter
import com.example.foodrecipeapp.data.model.Recipe
import com.example.foodrecipeapp.data.repo.FetchDataResult
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
    private val homeAdapter: HomeAdapter by lazy {
        HomeAdapter()
    }

    override fun createBindingFragment(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        binding.rcvRecipes.adapter = homeAdapter
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
        val convertedList: MutableList<Recipe> = mutableListOf()

        for (item in listRecipes) {
            if (item is Recipe) {
                convertedList.add(item)
            }
        }

        homeAdapter.setData(convertedList)
    }

    override fun onError(exception: Exception?) {
        Toast.makeText(context, exception?.message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}
