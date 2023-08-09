package com.example.foodrecipeapp.data.repo.source.remote.fetchjson

import com.example.foodrecipeapp.listener.OnResultListener

class GetJsonFromUrl<T> constructor(
    @Suppress("UnusedPrivateMember")
    private val urlString: String,
    @Suppress("UnusedPrivateMember")
    private val keyEntity: String,
    @Suppress("UnusedPrivateMember")
    private val listener: OnResultListener<T>
)
