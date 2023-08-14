package com.example.foodrecipeapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AnalyzedInstruction(
    val name: String = "",
    val steps: MutableList<Step> = mutableListOf()
) : Parcelable

object AnalyzedInstructionEntry {
    const val NAME_KEY = "name"
    const val STEP_KEY = "steps"
}
