package com.example.foodrecipeapp.data.repo

import android.content.ContentResolver
import androidx.lifecycle.LifecycleOwner
import com.example.foodrecipeapp.data.model.Recipe
import com.example.foodrecipeapp.data.repo.source.RecipeDataSource
import com.example.foodrecipeapp.listener.OnResultListener

class RecipeRepo private constructor(
    private val local: RecipeDataSource.Local?,
    private val remote: RecipeDataSource.Remote?
) : RecipeDataSource.Local, RecipeDataSource.Remote {
    override fun getRecipesLocal(
        contentResolver: ContentResolver,
        listener: OnResultListener<MutableList<Recipe>>
    ) {
        local?.getRecipesLocal(contentResolver, listener)
    }

    override fun getRecipesRemote(listener: OnResultListener<FetchDataResult<MutableList<Any>>>) {
        remote?.getRecipesRemote(listener)
    }

    override fun getListFavouritesRecipes(
        listener: OnResultListener<FetchDataResult<MutableList<Any>>>,
        viewLifecycleOwner: LifecycleOwner
    ) {
        remote?.getListFavouritesRecipes(listener, viewLifecycleOwner)
    }

    override fun getRecipeDetail(
        listener: OnResultListener<FetchDataResult<Any>>,
        recipeId: Int
    ) {
        remote?.getRecipeDetail(listener, recipeId)
    }

    override fun searchRecipesRemote(
        listener: OnResultListener<FetchDataResult<MutableList<Any>>>,
        searchValue: String
    ) {
        remote?.searchRecipesRemote(listener, searchValue)
    }

    override fun searchRecipesInList(
        listener: OnResultListener<FetchDataResult<MutableList<Any>>>,
        searchValue: String,
        listRecipes: MutableList<Recipe>
    ) {
        remote?.searchRecipesInList(listener, searchValue, listRecipes)
    }

    override fun searchRecentRecipesInList(
        listener: OnResultListener<FetchDataResult<MutableList<Any>>>,
        searchValue: String,
        listRecentRecipes: MutableList<Recipe>
    ) {
        remote?.searchRecentRecipesInList(listener, searchValue, listRecentRecipes)
    }

    companion object {
        private var instance: RecipeRepo? = null

        fun getInstanceRecipeLocalRepo(local: RecipeDataSource.Local): RecipeRepo {
            return synchronized(this) {
                instance ?: RecipeRepo(local, null).also {
                    instance = it
                }
            }
        }

        fun getInstanceRecipeRemoteRepo(remote: RecipeDataSource.Remote): RecipeRepo {
            return synchronized(this) {
                instance ?: RecipeRepo(null, remote).also {
                    instance = it
                }
            }
        }
    }
}
