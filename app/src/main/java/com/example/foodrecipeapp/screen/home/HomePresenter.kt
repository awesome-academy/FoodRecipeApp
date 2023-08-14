package com.example.foodrecipeapp.screen.home

import com.example.foodrecipeapp.data.repo.FetchDataResult
import com.example.foodrecipeapp.data.repo.RecipeRepo
import com.example.foodrecipeapp.listener.OnResultListener

class HomePresenter(
    private val recipeRepo: RecipeRepo?
) : HomeContract.Presenter {

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
        recipeRepo?.getRecipesRemote(object : OnResultListener<FetchDataResult<MutableList<Any>>> {
            override fun onSuccess(dataResult: FetchDataResult<MutableList<Any>>) {
                when (dataResult) {
                    is FetchDataResult.Success -> view?.onGetRecipesSuccess(dataResult.data)
                    is FetchDataResult.Error -> view?.onError(dataResult.exception)
                }
            }

            override fun onError(exception: Exception?) {
                view?.onError(exception)
            }
        })
    }
}