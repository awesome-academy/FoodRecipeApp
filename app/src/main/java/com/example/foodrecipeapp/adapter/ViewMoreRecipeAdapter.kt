package com.example.foodrecipeapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodrecipeapp.data.model.Recipe
import com.example.foodrecipeapp.databinding.ItemRecipeMoreBinding

class ViewMoreRecipeAdapter :
    RecyclerView.Adapter<ViewMoreRecipeAdapter.ViewMoreRecipeViewHolder>() {

    private var listRecipes: MutableList<Recipe> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewMoreRecipeViewHolder {
        val binding =
            ItemRecipeMoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewMoreRecipeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listRecipes.size
    }

    override fun onBindViewHolder(holder: ViewMoreRecipeViewHolder, position: Int) {
        holder.bindData()
    }

    fun setData(listRecipes: MutableList<Recipe>) {
        this.listRecipes = listRecipes
    }

    inner class ViewMoreRecipeViewHolder(private val binding: ItemRecipeMoreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData() {
            // TODO("Not yet implemented")
        }
    }
}
