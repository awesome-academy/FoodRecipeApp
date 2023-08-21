package com.example.foodrecipeapp.presenter

import com.example.foodrecipeapp.data.model.Recipe
import com.example.foodrecipeapp.enum.CategoryPresenterType

interface CategoryPresenter {
    fun searchRecipes(searchValue: String)
    fun filterCategory(category: String, listRecipes: MutableList<Recipe>)
    fun getPresenterType(): CategoryPresenterType
}
