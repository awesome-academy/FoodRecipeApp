package com.example.foodrecipeapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Equipment(
    val id: Int = 0,
    val name: String = "",
    val localizedName: String = "",
    val image: String = ""
) : Parcelable

object EquipmentEntry {
    const val ID_KEY = "id"
    const val NAME_KEY = "name"
    const val LOCALIZED_NAME_KEY = "localizedName"
    const val IMAGE_KEY = "image"
}
