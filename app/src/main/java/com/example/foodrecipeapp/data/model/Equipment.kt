package com.example.foodrecipeapp.data.model

data class Equipment(
    private val id: Int,
    private val name: String,
    private val localizedName: String,
    private val image: String,
    private val temperature: Temperature
)
