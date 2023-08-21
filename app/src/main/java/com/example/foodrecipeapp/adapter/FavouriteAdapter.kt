package com.example.foodrecipeapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodrecipeapp.R
import com.example.foodrecipeapp.data.model.Recipe
import com.example.foodrecipeapp.databinding.ItemFavouriteRecipeBinding
import com.example.foodrecipeapp.utils.DataLocalManager
import com.example.foodrecipeapp.utils.ext.loadImageWithUrl

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
        holder.bindData(favouriteRecipes[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(listRecipes: MutableList<Recipe>) {
        favouriteRecipes = listRecipes
        notifyDataSetChanged()
    }

    private fun handleClickFavouriteButton() {
        // TODO("Not yet implemented")
    }

    inner class FavouriteViewHolder(private val binding: ItemFavouriteRecipeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bindData(recipe: Recipe) {
            binding.imgFood.loadImageWithUrl(recipe.image)
            binding.tvTitle.text = recipe.title

            binding.tvDishType.text = recipe.dishTypes.joinToString(", ")

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
                binding.tvEstimateTime.text = "${recipe.readyInMinutes} Mins"
            }

            val isFavourite =
                DataLocalManager.favouriteRecipesLiveData.value?.contains(recipe) == true
            if (isFavourite) {
                binding.btnFavourite.setIconTintResource(R.color.colorAccent)
            } else {
                binding.btnFavourite.setIconTintResource(R.color.black)
            }

            binding.btnFavourite.setOnClickListener {
                handleClickFavouriteButton()
            }
        }
    }
}
