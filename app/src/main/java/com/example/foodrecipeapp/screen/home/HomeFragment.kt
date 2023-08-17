package com.example.foodrecipeapp.screen.home

import android.app.ProgressDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.example.foodrecipeapp.R
import com.example.foodrecipeapp.adapter.HomeChildAdapter
import com.example.foodrecipeapp.data.model.HomeChild
import com.example.foodrecipeapp.data.model.Recipe
import com.example.foodrecipeapp.data.repo.RecipeRepo
import com.example.foodrecipeapp.data.repo.source.remote.RecipeRemoteDataSource
import com.example.foodrecipeapp.databinding.FragmentHomeBinding
import com.example.foodrecipeapp.listener.OnItemRecyclerViewClickListener
import com.example.foodrecipeapp.listener.OnRecipeItemClickListener
import com.example.foodrecipeapp.utils.base.BaseViewBindingFragment

class HomeFragment :
    BaseViewBindingFragment<FragmentHomeBinding>(),
    HomeContract.View,
    OnItemRecyclerViewClickListener<Recipe>,
    OnRecipeItemClickListener {

    private lateinit var homePresenter: HomePresenter

    private val homeChildAdapter: HomeChildAdapter by lazy {
        HomeChildAdapter(
            resources = resources,
            presenter = homePresenter,
            recipeItemClickListener = this
        )
    }

    private lateinit var dialog: ProgressDialog

    override fun createBindingFragment(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        homeChildAdapter.setData(getListHomeChild())
        binding.rcvHomeParent.adapter = homeChildAdapter

        dialog = ProgressDialog(context)
        dialog.setTitle(getString(R.string.loading))
        dialog.show()
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

    override fun onGetRandomRecipesSuccess(listRecipes: MutableList<Any>) {
        val convertedList: MutableList<Recipe> = mutableListOf()

        for (item in listRecipes) {
            if (item is Recipe) {
                convertedList.add(item)
            }
        }

        homeChildAdapter.setRandomListRecipes(convertedList)
        dialog.dismiss()
    }

    override fun onGetRandomVietnameseRecipesSuccess(listRecipes: MutableList<Any>) {
        val convertedList: MutableList<Recipe> = mutableListOf()

        for (item in listRecipes) {
            if (item is Recipe) {
                convertedList.add(item)
            }
        }

        homeChildAdapter.setRandomListVietnameseRecipes(convertedList)
        dialog.dismiss()
    }

    override fun onError(exception: Exception?) {
        Toast.makeText(context, exception?.message, Toast.LENGTH_SHORT).show()
    }

    override fun onSearchRecipe(searchValue: String) {
        homePresenter.searchRecipes(searchValue)
    }

    override fun onRecipeImageClick(recipe: Recipe) {
        Toast.makeText(requireContext(), recipe.title, Toast.LENGTH_SHORT).show()
        onItemClick(recipe)
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
