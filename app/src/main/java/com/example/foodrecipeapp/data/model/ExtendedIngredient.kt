package com.example.foodrecipeapp.data.model

data class ExtendedIngredient(
    private val id: Int,
    private val aisle: String,
    private val image: String,
    private val consistency: String,
    private val name: String,
    private val nameClean: String,
    private val original: String,
    private val originalString: String,
    private val originalName: String,
    private val amount: Double,
    private val unit: String,
    private val meta: ArrayList<String>,
    private val metaInformation: ArrayList<String>,
    private val measure: Measure
)
