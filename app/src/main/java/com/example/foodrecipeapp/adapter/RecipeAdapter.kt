package com.example.foodrecipeapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.foodrecipeapp.R
import com.example.foodrecipeapp.data.model.Recipe
import com.example.foodrecipeapp.databinding.ItemRecipeBinding
import com.example.foodrecipeapp.listener.OnRecipeItemClickListener
import com.example.foodrecipeapp.utils.DataLocalManager
import com.example.foodrecipeapp.utils.ext.loadImageWithUrl
import com.example.foodrecipeapp.utils.ext.notNull

class RecipeAdapter(
    private val recipeItemClickListener: OnRecipeItemClickListener
) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    private var listRandomRecipes: ArrayList<Recipe> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding = ItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return minOf(MAX_ITEM_SHOW_REVIEW, listRandomRecipes.size)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
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

    @SuppressLint("NotifyDataSetChanged")
    private fun handleClickFavouriteButton(binding: ItemRecipeBinding, recipe: Recipe) {
        recipe.isFavourite = !recipe.isFavourite

        if (recipe.isFavourite) {
            binding.btnFavourite.setIconTintResource(R.color.colorAccent)
            Toast.makeText(binding.root.context, R.string.bookmark_recipe, Toast.LENGTH_SHORT)
                .show()
            DataLocalManager.addFavouriteRecipe(recipe)
        } else {
            binding.btnFavourite.setIconTintResource(R.color.black)
            Toast.makeText(binding.root.context, R.string.unmark_recipe, Toast.LENGTH_SHORT)
                .show()
            DataLocalManager.removeFavouriteRecipe(recipe)
        }

        notifyDataSetChanged()
    }

    inner class RecipeViewHolder(private val binding: ItemRecipeBinding) :
        RecyclerView.ViewHolder(binding.root) {
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
                binding.tvEstimateTime.text = "${recipe.readyInMinutes} Mins"
            }

            recipe.image.notNull {
                binding.imgFood.loadImageWithUrl(it)
            }

            val isFavourite =
                DataLocalManager.favouriteRecipesLiveData.value?.contains(recipe) == true
            if (isFavourite) {
                binding.btnFavourite.setIconTintResource(R.color.colorAccent)
            } else {
                binding.btnFavourite.setIconTintResource(R.color.black)
            }

            binding.imgFood.setOnClickListener {
                recipeItemClickListener.onRecipeImageClick(recipe)
            }

            binding.btnFavourite.setOnClickListener {
                handleClickFavouriteButton(binding, recipe)
            }
        }
    }

    companion object {
        private const val MAX_ITEM_SHOW_REVIEW = 5
    }
}
