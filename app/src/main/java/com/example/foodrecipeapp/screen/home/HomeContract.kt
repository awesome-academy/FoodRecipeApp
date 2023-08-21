package com.example.foodrecipeapp.screen.home

import com.example.foodrecipeapp.data.model.Recipe
import com.example.foodrecipeapp.utils.base.BasePresenter
import java.lang.Exception

class HomeContract {
    /**
     * View
     */
    interface View {
        fun onGetRandomRecipesSuccess(listRecipes: MutableList<Recipe>)
        fun onGetRandomVietnameseRecipesSuccess(listRecipes: MutableList<Recipe>)
        fun onSearchRecipe(searchValue: String)
        fun onViewMoreRecipes()
        fun onViewMoreRecentRecipes()
        fun onError(exception: Exception?)
    }

    /**
     * Presenter
     */
    interface Presenter : BasePresenter<View> {
        fun getRecipes()
        fun searchRecipes(searchValue: String)
        fun viewMoreRecipes()
        fun viewMoreRecentRecipes()
    }
}
