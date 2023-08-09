package com.example.foodrecipeapp.data.model

data class Equipment(
    @Suppress("UnusedPrivateMember")
    private val id: Int,
    @Suppress("UnusedPrivateMember")
    private val name: String,
    @Suppress("UnusedPrivateMember")
    private val localizedName: String,
    @Suppress("UnusedPrivateMember")
    private val image: String,
    @Suppress("UnusedPrivateMember")
    private val temperature: Temperature
)
