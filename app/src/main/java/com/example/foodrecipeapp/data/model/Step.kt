package com.example.foodrecipeapp.data.model

data class Step(
    @Suppress("UnusedPrivateMember")
    private val number: Int,
    @Suppress("UnusedPrivateMember")
    private val step: String,
    @Suppress("UnusedPrivateMember")
    private val ingredients: ArrayList<Ingredient>,
    @Suppress("UnusedPrivateMember")
    private val equipments: ArrayList<Equipment>,
    @Suppress("UnusedPrivateMember")
    private val length: Length
)
