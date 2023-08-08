package com.example.foodrecipeapp.data.repo.source.remote

import com.example.foodrecipeapp.constant.Constant
import com.example.foodrecipeapp.data.model.Recipe
import com.example.foodrecipeapp.data.model.RecipeEntry
import com.example.foodrecipeapp.data.repo.source.RecipeDataSource
import com.example.foodrecipeapp.data.repo.source.remote.fetchjson.GetJsonFromUrl
import com.example.foodrecipeapp.listener.OnResultListener

class RecipeRemoteDataSource : RecipeDataSource.Remote {
    override fun getRecipesRemote(listener: OnResultListener<MutableList<Recipe>>) {
        GetJsonFromUrl(
            urlString = Constant.BASE_URL + Constant.BASE_URL_RECIPES,
            keyEntity = RecipeEntry.SEARCH_RECIPES,
            listener = listener
        )
    }

    companion object {
        private var instance: RecipeRemoteDataSource? = null

        fun getInstance() = synchronized(this) {
            instance ?: RecipeRemoteDataSource().also { instance = it }
        }
    }
}
