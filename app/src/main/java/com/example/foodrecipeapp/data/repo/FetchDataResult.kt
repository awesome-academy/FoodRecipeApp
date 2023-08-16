package com.example.foodrecipeapp.data.repo

import java.lang.Exception

sealed class FetchDataResult<out T> {
    data class Success<T>(val data: T, val fetchDataType: Int) : FetchDataResult<T>()
    data class Error(val exception: Exception) : FetchDataResult<Nothing>()
}
