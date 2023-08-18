package com.example.foodrecipeapp.listener

import com.example.foodrecipeapp.data.repo.FetchDataResult

interface OnResultListener<T> {
    fun onSuccess(dataResult: FetchDataResult<MutableList<Any>>)
    fun onError(exception: Exception?)
}
