package com.example.foodrecipeapp.screen.favourites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodrecipeapp.R
import com.example.foodrecipeapp.adapter.CategoryAdapter
import com.example.foodrecipeapp.adapter.FavouriteAdapter
import com.example.foodrecipeapp.data.model.Recipe
import com.example.foodrecipeapp.data.repo.RecipeRepo
import com.example.foodrecipeapp.data.repo.source.remote.RecipeRemoteDataSource
import com.example.foodrecipeapp.databinding.FragmentFavouriteBinding
import com.example.foodrecipeapp.listener.OnItemRecyclerViewClickListener
import com.example.foodrecipeapp.utils.base.BaseViewBindingFragment
import java.lang.Exception

class FavouriteFragment :
    BaseViewBindingFragment<FragmentFavouriteBinding>(),
    FavouriteContract.View,
    OnItemRecyclerViewClickListener<Recipe> {

    private lateinit var favouritePresenter: FavouritePresenter

    override fun createBindingFragment(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFavouriteBinding {
        return FragmentFavouriteBinding.inflate(inflater, container, false)
    }

    private val favouriteAdapter: FavouriteAdapter by lazy {
        FavouriteAdapter()
    }

    private val categoryAdapter: CategoryAdapter by lazy {
        CategoryAdapter(null)
    }

    override fun initData() {
        favouritePresenter = FavouritePresenter(
            RecipeRepo.getInstanceRecipeRemoteRepo(RecipeRemoteDataSource.getInstance())
        )
        favouritePresenter.setView(this)
        favouritePresenter.getListFavouritesRecipes(viewLifecycleOwner)
    }

    override fun initView() {
        binding.rcvFavouriteRecipes.adapter = favouriteAdapter

        categoryAdapter.setData(getListCategories())
        binding.rcvCategory.adapter = categoryAdapter
    }

    override fun onItemClick(item: Recipe) {
        // TODO("Not yet implemented")
    }

    override fun onGetFavouritesRecipes(listFavouritesRecipes: MutableList<Any>) {
        val convertedList: MutableList<Recipe> = mutableListOf()

        for (favouriteRecipe in listFavouritesRecipes) {
            if (favouriteRecipe is Recipe) {
                convertedList.add(favouriteRecipe)
            }
        }

        updateFavouritesList(convertedList)
    }

    override fun onError(exception: Exception?) {
        // TODO("Not yet implemented")
    }

    private fun getListCategories(): MutableList<String> {
        val categoriesArray = resources.getStringArray(R.array.categories)

        return categoriesArray.sorted().toMutableList()
    }

    private fun updateFavouritesList(favourites: MutableList<Recipe>) {
        val totalFavouriteRecipes = favourites.size

        if (totalFavouriteRecipes == 0) {
            binding.tvNoFavouriteRecipeFound.visibility = View.VISIBLE
            binding.imgNoFavouriteRecipeFound.visibility = View.VISIBLE
            binding.rcvCategory.visibility = View.GONE
            binding.rcvFavouriteRecipes.visibility = View.GONE
        } else {
            binding.tvNoFavouriteRecipeFound.visibility = View.GONE
            binding.imgNoFavouriteRecipeFound.visibility = View.GONE
            binding.rcvCategory.visibility = View.VISIBLE
            binding.rcvFavouriteRecipes.visibility = View.VISIBLE

            favouriteAdapter.setData(favourites)
            binding.rcvFavouriteRecipes.adapter = favouriteAdapter
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = FavouriteFragment()
    }
}
