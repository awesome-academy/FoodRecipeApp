package com.example.foodrecipeapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductMatch(
    var id: Int = 0,
    var title: String = "",
    var description: String = "",
    var price: String = "",
    var imageUrl: String = "",
    var averageRating: Double = 0.0,
    var ratingCount: Double = 0.0,
    var score: Double = 0.0,
    var link: String = ""
) : Parcelable

object ProductMatchEntry {
    const val ID_KEY = "id"
    const val TITLE_KEY = "title"
    const val DESCRIPTION_KEY = "description"
    const val PRICE_KEY = "price"
    const val IMAGE_URL_KEY = "imageUrl"
    const val AVERAGE_RATING_KEY = "averageRating"
    const val RATING_COUNT_KEY = "ratingCount"
    const val SCORE_KEY = "score"
    const val LINK_KEY = "link"
}
