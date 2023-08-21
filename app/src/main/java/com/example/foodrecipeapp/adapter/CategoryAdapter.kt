package com.example.foodrecipeapp.adapter

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.foodrecipeapp.R
import com.example.foodrecipeapp.data.model.Recipe
import com.example.foodrecipeapp.databinding.ItemCategoryBinding
import com.example.foodrecipeapp.enum.CategoryPresenterType
import com.example.foodrecipeapp.presenter.CategoryPresenter
import java.util.Locale

class CategoryAdapter(
    private val presenter: CategoryPresenter?,
    private val listRecipes: MutableList<Recipe>?
) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private var listCategories: MutableList<String> = mutableListOf()
    private var currentIndex = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding =
            ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listCategories.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bindData(listCategories[position], position)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(listCategories: MutableList<String>) {
        this.listCategories = listCategories
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun handleClickCategoryButton(item: String, position: Int) {
        if (currentIndex != position) {
            currentIndex = position
            presenter?.let {
                when (it.getPresenterType()) {
                    CategoryPresenterType.HOME_PRESENTER -> it.searchRecipes(item)
                    CategoryPresenterType.FAVOURITE_PRESENTER -> it.filterCategory(
                        item,
                        listRecipes!!
                    )
                }
            }
        }
        notifyDataSetChanged()
    }

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(category: String, position: Int) {
            binding.btnCategory.text = category.toLowerCase(Locale.ROOT).capitalize(Locale.ROOT)

            if (position == currentIndex) {
                binding.btnCategory.typeface = Typeface.DEFAULT_BOLD
                binding.btnCategory.setBackgroundColor(
                    ContextCompat.getColor(
                        binding.root.context,
                        R.color.colorAccent
                    )
                )
                binding.btnCategory.setTextColor(
                    ContextCompat.getColor(
                        binding.root.context,
                        R.color.white
                    )
                )
            } else {
                binding.btnCategory.setBackgroundColor(
                    ContextCompat.getColor(
                        binding.root.context,
                        R.color.white
                    )
                )
                binding.btnCategory.setTextColor(
                    ContextCompat.getColor(
                        binding.root.context,
                        R.color.colorAccent
                    )
                )
            }

            binding.btnCategory.setOnClickListener {
                handleClickCategoryButton(binding.btnCategory.text.toString().lowercase(), position)
            }
        }
    }
}
