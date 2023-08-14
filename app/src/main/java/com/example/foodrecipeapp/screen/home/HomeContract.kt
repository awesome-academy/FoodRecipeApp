package com.example.foodrecipeapp.screen.home

import com.example.foodrecipeapp.utils.base.BasePresenter
import java.lang.Exception

class HomeContract {
    /**
     * View
     */
    interface View {
        fun onGetRecipesSuccess(listRecipes: MutableList<Any>)
        fun onError(exception: Exception?)
    }

    /**
     * Presenter
     */
    interface Presenter : BasePresenter<View> {
        fun getRecipes()
    }
}
