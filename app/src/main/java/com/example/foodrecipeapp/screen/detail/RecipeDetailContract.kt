package com.example.foodrecipeapp.screen.detail

import com.example.foodrecipeapp.data.model.RecipeDetail
import com.example.foodrecipeapp.utils.base.BasePresenter
import java.lang.Exception

class RecipeDetailContract {
    /**
     * View
     */
    interface View {
        fun onGetRecipeDetail(recipeDetail: RecipeDetail)
        fun onError(exception: Exception?)
    }

    /**
     * Presenter
     */
    interface Presenter : BasePresenter<View> {
        fun getRecipeDetail(recipeId: Int)
    }
}
