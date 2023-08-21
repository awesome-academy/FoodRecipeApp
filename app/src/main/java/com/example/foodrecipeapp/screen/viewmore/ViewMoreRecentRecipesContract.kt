package com.example.foodrecipeapp.screen.viewmore

import com.example.foodrecipeapp.data.model.Recipe
import com.example.foodrecipeapp.utils.base.BasePresenter
import java.lang.Exception

class ViewMoreRecentRecipesContract {
    /**
     * View
     */
    interface View {
        fun handleClickSearchRecentRecipe(searchValue: String)
        fun onSearchRecentRecipesInList(listRecentRecipes: MutableList<Recipe>)
        fun onError(exception: Exception?)
    }

    /**
     * Presenter
     */
    interface Presenter : BasePresenter<View> {
        fun searchRecentRecipesInList(listRecentRecipes: MutableList<Recipe>, searchValue: String)
    }
}
