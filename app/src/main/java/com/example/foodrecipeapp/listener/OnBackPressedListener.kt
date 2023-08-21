package com.example.foodrecipeapp.listener

import com.example.foodrecipeapp.data.model.Recipe

interface OnBackPressedListener {
    fun onBackPressedWithData(listRecipes: MutableList<Recipe>)
}
