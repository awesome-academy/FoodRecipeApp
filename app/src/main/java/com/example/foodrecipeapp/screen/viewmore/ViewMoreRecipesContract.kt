package com.example.foodrecipeapp.screen.viewmore

import com.example.foodrecipeapp.data.model.Recipe
import com.example.foodrecipeapp.utils.base.BasePresenter
import java.lang.Exception

class ViewMoreRecipesContract {
    /**
     * View
     */
    interface View {
        fun handleClickSearchRecipe(searchValue: String)
        fun onSearchRecipesInList(listRecipes: MutableList<Recipe>)
        fun onError(exception: Exception?)
    }

    /**
     * Presenter
     */
    interface Presenter : BasePresenter<View> {
        fun searchRecipesInList(listRecipes: MutableList<Recipe>, searchValue: String)
    }
}
