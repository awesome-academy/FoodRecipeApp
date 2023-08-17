package com.example.foodrecipeapp.listener

import com.example.foodrecipeapp.data.model.Recipe

interface OnRecipeItemClickListener {
    fun onRecipeImageClick(recipe: Recipe)
}
