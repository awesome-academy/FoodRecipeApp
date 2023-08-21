package com.example.foodrecipeapp.screen.viewmore

import com.example.foodrecipeapp.data.model.Recipe
import com.example.foodrecipeapp.data.repo.FetchDataResult
import com.example.foodrecipeapp.data.repo.RecipeRepo
import com.example.foodrecipeapp.listener.OnResultListener

class ViewMoreRecentRecipesPresenter(
    private val recipeRepo: RecipeRepo?
) : ViewMoreRecentRecipesContract.Presenter {

    private var view: ViewMoreRecentRecipesContract.View? = null

    override fun onStart() {
        // TODO("Not yet implemented")
    }

    override fun onStop() {
        // TODO("Not yet implemented")
    }

    override fun setView(view: ViewMoreRecentRecipesContract.View?) {
        this.view = view
    }

    override fun searchRecentRecipesInList(
        listRecentRecipes: MutableList<Recipe>,
        searchValue: String
    ) {
        recipeRepo?.searchRecentRecipesInList(
            object :
                OnResultListener<MutableList<Recipe>> {
                override fun onSuccess(dataResult: FetchDataResult<MutableList<Recipe>>) {
                    when (dataResult) {
                        is FetchDataResult.Success -> {
                            if (dataResult.fetchDataType == FetchDataResult.FETCH_TYPE_SEARCH_RECENT_RECIPES) {
                                view?.onSearchRecentRecipesInList(dataResult.data)
                            }
                        }
                        is FetchDataResult.Error -> view?.onError(dataResult.exception)
                    }
                }

                override fun onError(exception: Exception?) {
                    view?.onError(exception)
                }
            },
            searchValue,
            listRecentRecipes
        )
    }
}
