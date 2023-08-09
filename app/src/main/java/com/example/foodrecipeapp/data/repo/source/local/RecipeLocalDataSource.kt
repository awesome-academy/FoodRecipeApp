package com.example.foodrecipeapp.data.repo.source.local

import android.content.ContentResolver
import com.example.foodrecipeapp.data.model.Recipe
import com.example.foodrecipeapp.data.repo.source.RecipeDataSource
import com.example.foodrecipeapp.listener.OnResultListener

class RecipeLocalDataSource : RecipeDataSource.Local {
    override fun getRecipesLocal(
        contentResolver: ContentResolver,
        listener: OnResultListener<MutableList<Recipe>>
    ) {
//        TODO("Not yet implemented")
    }

    companion object {
        private var instance: RecipeLocalDataSource? = null

        fun getInstance() = synchronized(this) {
            instance ?: RecipeLocalDataSource().also { instance = it }
        }
    }
}
