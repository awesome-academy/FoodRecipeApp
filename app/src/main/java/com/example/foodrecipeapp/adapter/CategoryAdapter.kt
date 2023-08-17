package com.example.foodrecipeapp.adapter

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.foodrecipeapp.R
import com.example.foodrecipeapp.databinding.ItemCategoryBinding
import com.example.foodrecipeapp.screen.home.HomePresenter

class CategoryAdapter(private val presenter: HomePresenter) :
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

    private fun handleClickCategoryButton(item: String) {
        presenter.searchRecipes(item)
    }

    fun setActiveIndex(index: Int) {
        if (currentIndex != index) {
            val previousActiveIndex = currentIndex
            currentIndex = index
            notifyItemChanged(previousActiveIndex)
            notifyItemChanged(currentIndex)
        }
    }

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(category: String, position: Int) {
            binding.btnCategory.text = category

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
                setActiveIndex(position)
                handleClickCategoryButton(binding.btnCategory.text.toString())
            }
        }
    }
}
