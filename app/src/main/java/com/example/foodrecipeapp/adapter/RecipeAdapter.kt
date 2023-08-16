package com.example.foodrecipeapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodrecipeapp.data.model.Recipe
import com.example.foodrecipeapp.databinding.ItemRecipeBinding
import com.example.foodrecipeapp.utils.ext.loadImageWithUrl
import com.example.foodrecipeapp.utils.ext.notNull

class RecipeAdapter : RecyclerView.Adapter<RecipeAdapter.HomeViewHolder>() {

    private var listRandomRecipes: ArrayList<Recipe> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = ItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listRandomRecipes.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bindData(listRandomRecipes[position])
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
            binding.tvName.text = recipe.title

            if (recipe.servings <= 1) {
                binding.tvNumberServing.text = "${recipe.servings} Serving"
            } else {
                binding.tvNumberServing.text = "${recipe.servings} Servings"
            }

            if (recipe.aggregateLikes <= 1) {
                binding.tvNumberLike.text = "${recipe.aggregateLikes} Like"
            } else {
                binding.tvNumberLike.text = "${recipe.aggregateLikes} Likes"
            }

            if (recipe.readyInMinutes <= 1) {
                binding.tvEstimateTime.text = "${recipe.readyInMinutes} Min"
            } else {
                binding.tvEstimateTime.text = "${recipe.readyInMinutes} Minutes"
            }

            recipe.image.notNull {
                binding.imgFood.loadImageWithUrl(it)
            }
        }
    }
}
