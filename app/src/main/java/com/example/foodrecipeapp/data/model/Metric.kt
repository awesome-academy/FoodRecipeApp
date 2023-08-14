package com.example.foodrecipeapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Metric(
    val amount: Double = 0.0,
    val unitShort: String = "",
    val unitLong: String = ""
) : Parcelable

object MetricEntry {
    const val AMOUNT_KEY = "amount"
    const val UNIT_SHORT_KEY = "unitShort"
    const val UNIT_LONG_KEY = "unitLong"
}
