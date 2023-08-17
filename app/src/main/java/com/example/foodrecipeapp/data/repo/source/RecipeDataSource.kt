package com.example.foodrecipeapp.data.repo.source

import android.content.ContentResolver
import com.example.foodrecipeapp.data.model.Recipe
import com.example.foodrecipeapp.data.repo.FetchDataResult
import com.example.foodrecipeapp.listener.OnResultListener

interface RecipeDataSource {
    /**
     * Local
     */
    interface Local {
        fun getRecipesLocal(contentResolver: ContentResolver, listener: OnResultListener<MutableList<Recipe>>)
    }

    /**
     * Remote
     */
    interface Remote {
        fun getRecipesRemote(listener: OnResultListener<FetchDataResult<MutableList<Any>>>)
        fun searchRecipesRemote(listener: OnResultListener<FetchDataResult<MutableList<Any>>>, searchValue: String)
    }
}
