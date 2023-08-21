package com.example.foodrecipeapp.screen.favourites

import androidx.lifecycle.LifecycleOwner
import com.example.foodrecipeapp.data.model.Recipe
import com.example.foodrecipeapp.data.repo.FetchDataResult
import com.example.foodrecipeapp.data.repo.RecipeRepo
import com.example.foodrecipeapp.enum.CategoryPresenterType
import com.example.foodrecipeapp.listener.OnResultListener
import com.example.foodrecipeapp.presenter.CategoryPresenter

class FavouritePresenter(
    private val recipeRepo: RecipeRepo?
) : FavouriteContract.Presenter, CategoryPresenter {

    private var view: FavouriteContract.View? = null

    override fun onStart() {
        // TODO("Not yet implemented")
    }

    override fun onStop() {
        // TODO("Not yet implemented")
    }

    override fun setView(view: FavouriteContract.View?) {
        this.view = view
    }

    override fun getListFavouritesRecipes(viewLifecycleOwner: LifecycleOwner) {
        recipeRepo?.getListFavouritesRecipes(
            object :
                OnResultListener<FetchDataResult<MutableList<Any>>> {
                override fun onSuccess(dataResult: FetchDataResult<Any>) {
                    when (dataResult) {
                        is FetchDataResult.Success -> {
                            view?.onGetFavouritesRecipes(dataResult.data as MutableList<Any>)
                        }

                        is FetchDataResult.Error -> {
                            view?.onError(dataResult.exception)
                        }
                    }
                }

                override fun onError(exception: Exception?) {
                    view?.onError(exception)
                }
            },
            viewLifecycleOwner
        )
    }

    override fun searchRecipes(searchValue: String) {
        // TODO("Not yet implemented")
    }

    override fun filterCategory(category: String, listRecipes: MutableList<Recipe>) {
        recipeRepo?.filterRecipesByCategoryInList(
            object :
                OnResultListener<FetchDataResult<MutableList<Any>>> {
                override fun onSuccess(dataResult: FetchDataResult<Any>) {
                    when (dataResult) {
                        is FetchDataResult.Success -> {
                            if (dataResult.fetchDataType == FetchDataResult.FETCH_TYPE_FILTER_FAVOURITE_RECIPES) {
                                view?.onFilterFavouriteRecipes(dataResult.data as MutableList<Any>)
                            }
                        }
                        is FetchDataResult.Error -> view?.onError(dataResult.exception)
                    }
                }

                override fun onError(exception: Exception?) {
                    view?.onError(exception)
                }
            },
            category,
            listRecipes
        )
    }

    override fun getPresenterType(): CategoryPresenterType {
        return CategoryPresenterType.FAVOURITE_PRESENTER
    }
}
