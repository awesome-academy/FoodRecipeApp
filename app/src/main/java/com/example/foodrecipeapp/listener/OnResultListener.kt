package com.example.foodrecipeapp.listener

interface OnResultListener<T> {
    fun onSuccess(data: T)
    fun onError(exception: Exception?)
}
