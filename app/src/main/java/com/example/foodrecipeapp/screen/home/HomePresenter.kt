package com.example.foodrecipeapp.screen.home

import com.example.foodrecipeapp.data.model.Recipe
import com.example.foodrecipeapp.data.repo.FetchDataResult
import com.example.foodrecipeapp.data.repo.RecipeRepo
import com.example.foodrecipeapp.enum.CategoryPresenterType
import com.example.foodrecipeapp.listener.OnResultListener
import com.example.foodrecipeapp.presenter.CategoryPresenter

class HomePresenter(
    private val recipeRepo: RecipeRepo?
) : HomeContract.Presenter, CategoryPresenter {

    private var view: HomeContract.View? = null

    override fun onStart() {
        // TODO("Not yet implemented")
    }

    override fun onStop() {
        // TODO("Not yet implemented")
    }

    override fun setView(view: HomeContract.View?) {
        this.view = view
    }

    override fun getRecipes() {
        recipeRepo?.getRecipesRemote(object : OnResultListener<MutableList<Recipe>> {
            override fun onSuccess(dataResult: FetchDataResult<MutableList<Recipe>>) {
                when (dataResult) {
                    is FetchDataResult.Success -> {
                        if (dataResult.fetchDataType == FetchDataResult.FETCH_TYPE_RANDOM_RECIPE) {
                            view?.onGetRandomRecipesSuccess(dataResult.data)
                        } else {
                            view?.onGetRandomVietnameseRecipesSuccess(dataResult.data)
                        }
                    }
                    is FetchDataResult.Error -> view?.onError(dataResult.exception)
                }
            }

            override fun onError(exception: Exception?) {
                view?.onError(exception)
            }
        })
    }

    override fun searchRecipes(searchValue: String) {
        recipeRepo?.searchRecipesRemote(
            object :
                OnResultListener<MutableList<Recipe>> {
                override fun onSuccess(dataResult: FetchDataResult<MutableList<Recipe>>) {
                    when (dataResult) {
                        is FetchDataResult.Success -> {
                            if (dataResult.fetchDataType == FetchDataResult.FETCH_TYPE_RANDOM_RECIPE) {
                                view?.onGetRandomRecipesSuccess(dataResult.data)
                            } else {
                                view?.onGetRandomVietnameseRecipesSuccess(dataResult.data)
                            }
                        }

                        is FetchDataResult.Error -> view?.onError(dataResult.exception)
                    }
                }

                override fun onError(exception: Exception?) {
                    view?.onError(exception)
                }
            },
            searchValue
        )
    }

    override fun filterCategory(category: String, listRecipes: MutableList<Recipe>) {
        // TODO("Not yet implemented")
    }

    override fun getPresenterType(): CategoryPresenterType {
        return CategoryPresenterType.HOME_PRESENTER
    }

    override fun viewMoreRecipes() {
        view?.onViewMoreRecipes()
    }

    override fun viewMoreRecentRecipes() {
        view?.onViewMoreRecentRecipes()
    }
}
