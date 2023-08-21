package com.example.foodrecipeapp.listener

import com.example.foodrecipeapp.data.repo.FetchDataResult

interface OnResultListener<T> {
    fun onSuccess(dataResult: FetchDataResult<T>)
    fun onError(exception: Exception?)
}
