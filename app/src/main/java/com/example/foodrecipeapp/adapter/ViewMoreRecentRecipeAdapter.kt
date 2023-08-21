package com.example.foodrecipeapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodrecipeapp.data.model.Recipe
import com.example.foodrecipeapp.databinding.ItemRecentRecipeMoreBinding
import com.example.foodrecipeapp.listener.OnRecipeItemClickListener
import com.example.foodrecipeapp.utils.ext.loadImageWithUrl

class ViewMoreRecentRecipeAdapter(
    private val recipeItemClickListener: OnRecipeItemClickListener
) : RecyclerView.Adapter<ViewMoreRecentRecipeAdapter.ViewMoreRecentRecipeViewHolder>() {

    private var listRecentRecipes: MutableList<Recipe> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewMoreRecentRecipeViewHolder {
        val binding = ItemRecentRecipeMoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewMoreRecentRecipeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listRecentRecipes.size
    }

    override fun onBindViewHolder(holder: ViewMoreRecentRecipeViewHolder, position: Int) {
        holder.bindData(listRecentRecipes[position])
    }

    fun setData(listRecentRecipes: MutableList<Recipe>) {
        this.listRecentRecipes = listRecentRecipes
    }

    inner class ViewMoreRecentRecipeViewHolder(private val binding: ItemRecentRecipeMoreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(recentRecipe: Recipe) {
            binding.imgFood.loadImageWithUrl(recentRecipe.image)
            binding.tvRecipeName.text = recentRecipe.title

            binding.imgFood.setOnClickListener {
                recipeItemClickListener.onRecipeImageClick(recentRecipe)
            }
        }
    }
}
