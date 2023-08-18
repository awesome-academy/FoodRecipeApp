package com.example.foodrecipeapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodrecipeapp.data.model.Recipe
import com.example.foodrecipeapp.databinding.ItemFavouriteRecipeBinding

class FavouriteAdapter : RecyclerView.Adapter<FavouriteAdapter.FavouriteViewHolder>() {

    private var favouriteRecipes: MutableList<Recipe> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {
        val binding =
            ItemFavouriteRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavouriteViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return favouriteRecipes.size
    }

    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
        holder.bindData()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(listRecipes: MutableList<Recipe>) {
        favouriteRecipes = listRecipes
        notifyDataSetChanged()
    }

    inner class FavouriteViewHolder(private val binding: ItemFavouriteRecipeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData() {
            // TODO("Not yet implemented")
        }
    }
}
