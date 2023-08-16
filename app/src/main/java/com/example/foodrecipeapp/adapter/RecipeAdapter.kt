package com.example.foodrecipeapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodrecipeapp.data.model.Recipe
import com.example.foodrecipeapp.databinding.ItemRecipeBinding
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
        holder.bindData()
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
        fun bindData() {
            // TODO("Not yet implemented")
        }
    }
}
