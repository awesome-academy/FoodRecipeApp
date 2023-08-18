package com.example.foodrecipeapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodrecipeapp.data.model.Recipe
import com.example.foodrecipeapp.databinding.ItemRecentRecipeBinding
import com.example.foodrecipeapp.utils.ext.loadImageWithUrl
import com.example.foodrecipeapp.utils.ext.notNull

class RecentRecipeAdapter : RecyclerView.Adapter<RecentRecipeAdapter.RecentRecipeViewHolder>() {
    private var listRecentRecipes: ArrayList<Recipe> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentRecipeViewHolder {
        val binding =
            ItemRecentRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecentRecipeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return minOf(MAX_ITEM_COUNT, listRecentRecipes.size)
    }

    override fun onBindViewHolder(holder: RecentRecipeViewHolder, position: Int) {
        val recipe = listRecentRecipes[position]
        holder.bindData(recipe)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(recipes: MutableList<Recipe>?) {
        recipes.notNull {
            this.listRecentRecipes.clear()
            this.listRecentRecipes.addAll(it)
            notifyDataSetChanged()
        }
    }

    inner class RecentRecipeViewHolder(private val binding: ItemRecentRecipeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bindData(recipe: Recipe) {
            binding.tvName.text = recipe.title

            recipe.image.notNull {
                binding.imgFood.loadImageWithUrl(it)
            }
        }
    }

    companion object {
        private const val MAX_ITEM_COUNT = 5
    }
}
