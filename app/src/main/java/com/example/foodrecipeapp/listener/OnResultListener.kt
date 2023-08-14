package com.example.foodrecipeapp.listener

interface OnResultListener<T> {
    fun onSuccess(dataResult: T)
    fun onError(exception: Exception?)
}
