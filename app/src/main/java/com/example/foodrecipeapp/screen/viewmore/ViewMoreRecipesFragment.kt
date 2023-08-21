package com.example.foodrecipeapp.screen.viewmore

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.os.bundleOf
import com.example.foodrecipeapp.adapter.ViewMoreRecipeAdapter
import com.example.foodrecipeapp.data.model.Recipe
import com.example.foodrecipeapp.databinding.FragmentViewMoreRecipesBinding
import com.example.foodrecipeapp.listener.OnBackPressedListener
import com.example.foodrecipeapp.utils.base.BaseViewBindingFragment
import com.example.foodrecipeapp.utils.ext.goBackFragment

class ViewMoreRecipesFragment :
    BaseViewBindingFragment<FragmentViewMoreRecipesBinding>(),
    ViewMoreRecipesContract.View {

    private lateinit var viewMoreRecipesPresenter: ViewMoreRecipesPresenter
    private var listRecipes: MutableList<Recipe> = mutableListOf()
    private var onBackPressedListener: OnBackPressedListener? = null

    private val viewMoreRecipeAdapter: ViewMoreRecipeAdapter by lazy {
        ViewMoreRecipeAdapter()
    }

    override fun createBindingFragment(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentViewMoreRecipesBinding {
        return FragmentViewMoreRecipesBinding.inflate(inflater, container, false)
    }

    override fun initData() {
        viewMoreRecipesPresenter = ViewMoreRecipesPresenter()
        viewMoreRecipesPresenter.setView(this)
    }

    override fun initView() {
        arguments?.run {
            listRecipes = getParcelableArrayList(LIST_RECIPES)!!
        }
        viewMoreRecipeAdapter.setData(listRecipes)
        binding.rcvRecipes.adapter = viewMoreRecipeAdapter

        binding.imgBackButton.setOnClickListener {
            onBackPressedListener?.onBackPressedWithData(listRecipes)
            goBackFragment()
        }

        var searchValue = ""

        binding.searchRecipe.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val nonNullText: String = newText ?: ""
                searchValue = nonNullText
                return true
            }
        })

        binding.btnSearch.setOnClickListener {
            handleClickSearchRecipe(searchValue)
        }
    }

    override fun handleClickSearchRecipe(searchValue: String) {
        // TODO("Not yet implemented")
    }

    override fun onSearchRecipesInList(listRecipes: MutableList<Recipe>) {
        // TODO("Not yet implemented")
    }

    override fun onError(exception: Exception?) {
        Toast.makeText(context, exception?.message, Toast.LENGTH_SHORT).show()
    }

    fun setOnBackListener(listener: OnBackPressedListener) {
        onBackPressedListener = listener
    }

    companion object {
        private const val LIST_RECIPES = "LIST_RECIPES"

        @JvmStatic
        fun newInstance(listRecipes: MutableList<Recipe>) = ViewMoreRecipesFragment().apply {
            arguments = bundleOf(LIST_RECIPES to listRecipes)
        }
    }
}
