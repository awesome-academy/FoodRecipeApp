package com.example.foodrecipeapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ExtendedIngredient(
    val id: Int = 0,
    val aisle: String = "",
    val image: String = "",
    val consistency: String = "",
    val name: String = "",
    val nameClean: String = "",
    val original: String = "",
    val originalName: String = "",
    val amount: Double = 0.0,
    val unit: String = "",
    val meta: MutableList<String> = mutableListOf(),
    val measure: Measure = Measure()
) : Parcelable

object ExtendedIngredientEntry {
    const val ID_KEY = "id"
    const val AISLE_KEY = "aisle"
    const val IMAGE_KEY = "image"
    const val CONSISTENCY_KEY = "consistency"
    const val NAME_KEY = "name"
    const val NAME_CLEAN_KEY = "nameClean"
    const val ORIGINAL_KEY = "original"
    const val ORIGINAL_NAME_KEY = "originalName"
    const val AMOUNT_KEY = "amount"
    const val UNIT_KEY = "unit"
    const val META_KEY = "meta"
    const val MEASURES_KEY = "measures"
}
