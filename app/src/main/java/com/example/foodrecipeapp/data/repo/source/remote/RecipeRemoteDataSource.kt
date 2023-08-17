package com.example.foodrecipeapp.data.repo.source.remote

import com.example.foodrecipeapp.constant.Constant
import com.example.foodrecipeapp.data.model.RecipeEntry
import com.example.foodrecipeapp.data.repo.FetchDataResult
import com.example.foodrecipeapp.data.repo.source.RecipeDataSource
import com.example.foodrecipeapp.data.repo.source.remote.fetchjson.GetJsonFromUrl
import com.example.foodrecipeapp.listener.OnResultListener

class RecipeRemoteDataSource : RecipeDataSource.Remote {
    override fun getRecipesRemote(listener: OnResultListener<FetchDataResult<MutableList<Any>>>) {
        GetJsonFromUrl(
            urlString = Constant.BASE_URL + Constant.BASE_URL_RECIPE,
            keyEntity = RecipeEntry.RECIPES_OBJECT,
            listener = listener
        )
    }

    override fun searchRecipesRemote(
        listener: OnResultListener<FetchDataResult<MutableList<Any>>>,
        searchValue: String
    ) {
        GetJsonFromUrl(
            urlString = Constant.BASE_URL + Constant.BASE_URL_RECIPE,
            keyEntity = RecipeEntry.RECIPES_OBJECT,
            listener = listener,
            searchValue = searchValue
        ).searchRecipes()
    }

    companion object {
        private var instance: RecipeRemoteDataSource? = null

        fun getInstance() = synchronized(this) {
            instance ?: RecipeRemoteDataSource().also { instance = it }
        }
    }
}
