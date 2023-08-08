package com.example.foodrecipeapp.data.model

data class Step(
    private val number: Int,
    private val step: String,
    private val ingredients: ArrayList<Ingredient>,
    private val equipments: ArrayList<Equipment>,
    private val length: Length
)
