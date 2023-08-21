package com.example.foodrecipeapp.listener

import com.example.foodrecipeapp.data.repo.FetchDataResult

interface OnResultListener<T> {
    fun onSuccess(dataResult: FetchDataResult<Any>)
    fun onError(exception: Exception?)
}
