package com.example.foodrecipeapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Measure(
    val us: Us = Us(),
    val metric: Metric = Metric()
) : Parcelable

object MeasureEntry {
    const val US_KEY = "us"
    const val METRIC_KEY = "metric"
}
