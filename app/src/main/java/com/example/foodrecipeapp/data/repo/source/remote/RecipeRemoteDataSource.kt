package com.example.foodrecipeapp.data.repo.source.remote

import androidx.lifecycle.LifecycleOwner
import com.example.foodrecipeapp.constant.Constant
import com.example.foodrecipeapp.data.model.Recipe
import com.example.foodrecipeapp.data.model.RecipeEntry
import com.example.foodrecipeapp.data.repo.FetchDataResult
import com.example.foodrecipeapp.data.repo.source.RecipeDataSource
import com.example.foodrecipeapp.data.repo.source.remote.fetchjson.GetJsonFromUrl
import com.example.foodrecipeapp.listener.OnResultListener
import com.example.foodrecipeapp.utils.DataLocalManager

class RecipeRemoteDataSource : RecipeDataSource.Remote {
    override fun getRecipesRemote(listener: OnResultListener<FetchDataResult<MutableList<Any>>>) {
        GetJsonFromUrl(
            urlString = Constant.BASE_URL + Constant.BASE_URL_RECIPE,
            keyEntity = RecipeEntry.RECIPES_OBJECT,
            listener = listener
        )
    }

    override fun getListFavouritesRecipes(
        listener: OnResultListener<FetchDataResult<MutableList<Any>>>,
        viewLifecycleOwner: LifecycleOwner
    ) {
        DataLocalManager.favouriteRecipesLiveData.observe(viewLifecycleOwner) { favourites ->
            val fetchDataResult =
                FetchDataResult.Success(
                    favourites as MutableList<Any>,
                    FetchDataResult.FETCH_TYPE_FAVOURITE_RECIPES
                )
            listener.onSuccess(fetchDataResult)
        }
    }

    override fun getRecipeDetail(
        listener: OnResultListener<FetchDataResult<Any>>,
        recipeId: Int
    ) {
        GetJsonFromUrl(
            urlString = "$Constant.BASE_URL$Constant.BASE_URL_RECIPE$recipeId",
            keyEntity = "",
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

    override fun searchRecipesInList(
        listener: OnResultListener<FetchDataResult<MutableList<Any>>>,
        searchValue: String,
        listRecipes: MutableList<Recipe>
    ) {
        if (searchValue.trim().isEmpty()) {
            val result: FetchDataResult<MutableList<Any>> = FetchDataResult.Success(
                listRecipes.toMutableList(),
                FetchDataResult.FETCH_TYPE_SEARCH_RECIPES
            )
            listener.onSuccess(result)
        } else {
            val filterRecipes = listRecipes.filter { recipe ->
                recipe.title.contains(searchValue, ignoreCase = true)
            }
            val result: FetchDataResult<MutableList<Any>> = FetchDataResult.Success(
                filterRecipes.toMutableList(),
                FetchDataResult.FETCH_TYPE_SEARCH_RECIPES
            )
            listener.onSuccess(result)
        }
    }

    override fun searchRecentRecipesInList(
        listener: OnResultListener<FetchDataResult<MutableList<Any>>>,
        searchValue: String,
        listRecentRecipes: MutableList<Recipe>
    ) {
        if (searchValue.trim().isEmpty()) {
            val result: FetchDataResult<MutableList<Any>> = FetchDataResult.Success(
                listRecentRecipes.toMutableList(),
                FetchDataResult.FETCH_TYPE_SEARCH_RECENT_RECIPES
            )
            listener.onSuccess(result)
        } else {
            val filterRecipes = listRecentRecipes.filter { recipe ->
                recipe.title.contains(searchValue, ignoreCase = true)
            }
            val result: FetchDataResult<MutableList<Any>> = FetchDataResult.Success(
                filterRecipes.toMutableList(),
                FetchDataResult.FETCH_TYPE_SEARCH_RECENT_RECIPES
            )
            listener.onSuccess(result)
        }
    }

    companion object {
        private var instance: RecipeRemoteDataSource? = null

        fun getInstance() = synchronized(this) {
            instance ?: RecipeRemoteDataSource().also { instance = it }
        }
    }
}
