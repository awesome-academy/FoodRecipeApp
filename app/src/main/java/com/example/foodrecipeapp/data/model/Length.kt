package com.example.foodrecipeapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Length(
    val number: Int = 0,
    val unit: String = ""
) : Parcelable

object LengthEntry {
    const val NUMBER_KEY = "number"
    const val UNIT_KEY = "unit"
}
