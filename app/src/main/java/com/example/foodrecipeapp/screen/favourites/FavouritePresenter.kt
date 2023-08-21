package com.example.foodrecipeapp.screen.favourites

import androidx.lifecycle.LifecycleOwner
import com.example.foodrecipeapp.data.repo.FetchDataResult
import com.example.foodrecipeapp.data.repo.RecipeRepo
import com.example.foodrecipeapp.listener.OnResultListener

class FavouritePresenter(
    private val recipeRepo: RecipeRepo?
) : FavouriteContract.Presenter {

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

    override fun filterCategory(category: String) {
        // TODO("Not yet implemented")
    }
}
