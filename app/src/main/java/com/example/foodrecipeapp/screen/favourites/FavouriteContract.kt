package com.example.foodrecipeapp.screen.favourites

import androidx.lifecycle.LifecycleOwner
import com.example.foodrecipeapp.data.model.Recipe
import com.example.foodrecipeapp.utils.base.BasePresenter
import java.lang.Exception

class FavouriteContract {
    /**
     * View
     */
    interface View {
        fun onGetFavouritesRecipes(listFavouritesRecipes: MutableList<Recipe>)
        fun onFilterFavouriteRecipes(listFavouritesRecipes: MutableList<Recipe>)
        fun onError(exception: Exception?)
    }

    /**
     * Presenter
     */
    interface Presenter : BasePresenter<View> {
        fun getListFavouritesRecipes(viewLifecycleOwner: LifecycleOwner)
        fun filterCategory(category: String, listRecipes: MutableList<Recipe>)
    }
}
