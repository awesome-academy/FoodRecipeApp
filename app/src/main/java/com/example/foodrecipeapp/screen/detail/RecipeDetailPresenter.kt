package com.example.foodrecipeapp.screen.detail

import com.example.foodrecipeapp.data.model.RecipeDetail
import com.example.foodrecipeapp.data.repo.FetchDataResult
import com.example.foodrecipeapp.data.repo.RecipeRepo
import com.example.foodrecipeapp.listener.OnResultListener

class RecipeDetailPresenter(
    private val recipeRepo: RecipeRepo?
) : RecipeDetailContract.Presenter {

    private var view: RecipeDetailContract.View? = null

    override fun onStart() {
        // TODO("Not yet implemented")
    }

    override fun onStop() {
        // TODO("Not yet implemented")
    }

    override fun setView(view: RecipeDetailContract.View?) {
        this.view = view
    }

    override fun getRecipeDetail(recipeId: Int) {
        recipeRepo?.getRecipeDetail(
            object : OnResultListener<RecipeDetail> {
                override fun onSuccess(dataResult: FetchDataResult<RecipeDetail>) {
                    when (dataResult) {
                        is FetchDataResult.Success -> {
                            if (dataResult.fetchDataType == FetchDataResult.FETCH_TYPE_RECIPE_DETAIL) {
                                view?.onGetRecipeDetail(dataResult.data)
                            }
                        }

                        is FetchDataResult.Error -> view?.onError(dataResult.exception)
                    }
                }

                override fun onError(exception: Exception?) {
                    view?.onError(exception)
                }
            },
            recipeId
        )
    }
}
