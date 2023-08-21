package com.example.foodrecipeapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WinePairing(
    var pairedWines: MutableList<String> = mutableListOf(),
    var pairingText: String = "",
    var productMatches: MutableList<ProductMatch> = mutableListOf()
) : Parcelable

object WinePairingEntry {
    const val PAIRED_WINES_KEY = "pairedWines"
    const val PAIRING_TEXT_KEY = "pairingText"
    const val PRODUCT_MATCH_KEY = "productMatches"
}
