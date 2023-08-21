package com.example.foodrecipeapp.data.repo

import java.lang.Exception

sealed class FetchDataResult<out T> {
    data class Success<T>(val data: T, val fetchDataType: Int) : FetchDataResult<T>()
    data class Error(val exception: Exception) : FetchDataResult<Nothing>()

    companion object {
        const val FETCH_TYPE_RANDOM_RECIPE = 1
        const val FETCH_TYPE_RANDOM_VIETNAMESE_RECIPE = 2
        const val FETCH_TYPE_FAVOURITE_RECIPES = 3
        const val FETCH_TYPE_SEARCH_RECIPES = 4
        const val FETCH_TYPE_SEARCH_RECENT_RECIPES = 5
        const val FETCH_TYPE_RECIPE_DETAIL = 6
        const val FETCH_TYPE_FILTER_FAVOURITE_RECIPES = 7
    }
}
