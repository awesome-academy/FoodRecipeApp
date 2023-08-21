package com.example.foodrecipeapp.screen.viewmore

import com.example.foodrecipeapp.data.model.Recipe

class ViewMoreRecipesPresenter : ViewMoreRecipesContract.Presenter {

    private var view: ViewMoreRecipesContract.View? = null

    override fun onStart() {
        // TODO("Not yet implemented")
    }

    override fun onStop() {
        // TODO("Not yet implemented")
    }

    override fun setView(view: ViewMoreRecipesContract.View?) {
        this.view = view
    }

    override fun searchRecipesInList(listRecipes: MutableList<Recipe>, searchValue: String) {
        // TODO("Not yet implemented")
    }
}
