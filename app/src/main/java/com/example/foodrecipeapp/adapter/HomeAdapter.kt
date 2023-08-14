package com.example.foodrecipeapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodrecipeapp.data.model.Recipe
import com.example.foodrecipeapp.databinding.ItemRecipeBinding
import com.example.foodrecipeapp.utils.ext.loadImageWithUrl
import com.example.foodrecipeapp.utils.ext.notNull

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private var listRandomRecipes: ArrayList<Recipe> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = ItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listRandomRecipes.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val recipe = listRandomRecipes[position]
        holder.bindData(recipe)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(recipes: MutableList<Recipe>?) {
        recipes.notNull {
            this.listRandomRecipes.clear()
            this.listRandomRecipes.addAll(it)
            notifyDataSetChanged()
        }
    }

    inner class HomeViewHolder(private val binding: ItemRecipeBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bindData(recipe: Recipe) {
            binding.tvFood.text = recipe.title
            binding.tvServing.text = "${recipe.servings} Servings"
            binding.tvLikes.text = "${recipe.aggregateLikes} Likes"
            binding.tvTime.text = "${recipe.readyInMinutes} Minutes"
            recipe.image.notNull {
                binding.imgFood.loadImageWithUrl(it)
            }
        }
    }
}
