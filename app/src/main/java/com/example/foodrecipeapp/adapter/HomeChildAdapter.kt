package com.example.foodrecipeapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodrecipeapp.R
import com.example.foodrecipeapp.data.model.HomeChild
import com.example.foodrecipeapp.data.model.Recipe
import com.example.foodrecipeapp.databinding.LayoutPopularCategoryHomeChildBinding
import com.example.foodrecipeapp.databinding.LayoutRecentRecipeHomeChildBinding
import com.example.foodrecipeapp.databinding.LayoutSearchHomeChildBinding
import com.example.foodrecipeapp.listener.OnRecipeItemClickListener
import com.example.foodrecipeapp.screen.home.HomePresenter
import com.example.foodrecipeapp.utils.base.BaseViewHolder

class HomeChildAdapter(
    private val resources: Resources,
    private val presenter: HomePresenter,
    private val recipeItemClickListener: OnRecipeItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listHomeChild: MutableList<HomeChild> = mutableListOf()

    private val recipeAdapter: RecipeAdapter by lazy {
        RecipeAdapter(recipeItemClickListener)
    }

    private val recentRecipeAdapter: RecentRecipeAdapter by lazy {
        RecentRecipeAdapter(recipeItemClickListener)
    }

    private val categoryAdapter: CategoryAdapter by lazy {
        CategoryAdapter(presenter, null)
    }

    override fun getItemViewType(position: Int): Int {
        val homeChild = listHomeChild[position]
        return homeChild.typeView
    }

    @SuppressLint("ReturnCount")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            HOME_SEARCH_VIEW -> {
                HomeSearchRecipeViewHolder(
                    LayoutSearchHomeChildBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            HOME_POPULAR_CATEGORY_VIEW -> {
                HomePopularCategoryViewHolder(
                    LayoutPopularCategoryHomeChildBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            else -> {
                HomeRecentRecipeViewHolder(
                    LayoutRecentRecipeHomeChildBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return listHomeChild.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? BaseViewHolder<HomeChild>)?.bindData(listHomeChild[position])
    }

    private fun getListCategories(): MutableList<String> {
        val categoriesArray = resources.getStringArray(R.array.categories)

        return categoriesArray.sorted().toMutableList()
    }

    fun setRandomListRecipes(listRecipes: MutableList<Recipe>) {
        recipeAdapter.setData(listRecipes)
    }

    fun setRandomListVietnameseRecipes(listRecipes: MutableList<Recipe>) {
        recentRecipeAdapter.setData(listRecipes)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(listHomeChild: MutableList<HomeChild>) {
        this.listHomeChild = listHomeChild
        notifyDataSetChanged()
    }

    private fun handleClickSearchRecipe(context: Context, searchValue: String?) {
        if (searchValue != null) {
            if (searchValue.trim().isEmpty()) {
                Toast.makeText(context, R.string.no_search_input, Toast.LENGTH_SHORT).show()
            } else {
                presenter.searchRecipes(searchValue)
            }
        }
    }

    inner class HomeSearchRecipeViewHolder(private val binding: LayoutSearchHomeChildBinding) :
        BaseViewHolder<HomeChild>(binding) {
        override fun bindData(itemBinding: HomeChild) {
            var searchValue: String? = ""
            binding.searchViewHome.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    searchValue = newText
                    return true
                }
            })

            binding.btnSearch.setOnClickListener {
                handleClickSearchRecipe(binding.root.context, searchValue)
            }
        }
    }

    inner class HomePopularCategoryViewHolder(private val binding: LayoutPopularCategoryHomeChildBinding) :
        BaseViewHolder<HomeChild>(binding) {
        override fun bindData(itemBinding: HomeChild) {
            categoryAdapter.setData(getListCategories())
            binding.rcvCategory.adapter = categoryAdapter

            binding.rcvRecipes.adapter = recipeAdapter

            binding.tvSeeAll.setOnClickListener {
                presenter.viewMoreRecipes()
            }
        }
    }

    inner class HomeRecentRecipeViewHolder(private val binding: LayoutRecentRecipeHomeChildBinding) :
        BaseViewHolder<HomeChild>(binding) {
        override fun bindData(itemBinding: HomeChild) {
            binding.rcvRecentRecipes.adapter = recentRecipeAdapter

            binding.tvSeeAll.setOnClickListener {
                presenter.viewMoreRecentRecipes()
            }
        }
    }

    companion object {
        const val HOME_SEARCH_VIEW = 1
        const val HOME_POPULAR_CATEGORY_VIEW = 2
        const val HOME_RECENT_RECIPE_VIEW = 3
    }
}
