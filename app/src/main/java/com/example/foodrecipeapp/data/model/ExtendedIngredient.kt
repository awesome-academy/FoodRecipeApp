package com.example.foodrecipeapp.data.model

data class ExtendedIngredient(
    @Suppress("UnusedPrivateMember")
    private val id: Int,
    @Suppress("UnusedPrivateMember")
    private val aisle: String,
    @Suppress("UnusedPrivateMember")
    private val image: String,
    @Suppress("UnusedPrivateMember")
    private val consistency: String,
    @Suppress("UnusedPrivateMember")
    private val name: String,
    @Suppress("UnusedPrivateMember")
    private val nameClean: String,
    @Suppress("UnusedPrivateMember")
    private val original: String,
    @Suppress("UnusedPrivateMember")
    private val originalString: String,
    @Suppress("UnusedPrivateMember")
    private val originalName: String,
    @Suppress("UnusedPrivateMember")
    private val amount: Double,
    @Suppress("UnusedPrivateMember")
    private val unit: String,
    @Suppress("UnusedPrivateMember")
    private val meta: ArrayList<String>,
    @Suppress("UnusedPrivateMember")
    private val metaInformation: ArrayList<String>,
    @Suppress("UnusedPrivateMember")
    private val measure: Measure
)
