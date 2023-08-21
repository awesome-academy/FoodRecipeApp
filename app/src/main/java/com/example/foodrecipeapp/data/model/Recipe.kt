package com.example.foodrecipeapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipe(
    var vegetarian: Boolean = false,
    var vegan: Boolean = false,
    var glutenFree: Boolean = false,
    var dairyFree: Boolean = false,
    var veryHealthy: Boolean = false,
    var cheap: Boolean = false,
    var veryPopular: Boolean = false,
    var sustainable: Boolean = false,
    var weightWatcherSmartPoints: Int = 0,
    var gaps: String = "",
    var lowFodmap: Boolean = false,
    var preparationMinutes: Int = 0,
    var cookingMinutes: Int = 0,
    var aggregateLikes: Int = 0,
    var healthScore: Double = 0.0,
    var creditsText: String = "",
    var sourceName: String = "",
    var pricePerServing: Double = 0.0,
    var extendedIngredients: MutableList<ExtendedIngredient> = mutableListOf(),
    var id: Int = 0,
    var title: String = "",
    var readyInMinutes: Int = 0,
    var servings: Int = 0,
    var sourceUrl: String = "",
    var image: String = "",
    var imageType: String = "",
    var summary: String = "",
    var cuisines: MutableList<String> = mutableListOf(),
    var dishTypes: MutableList<String> = mutableListOf(),
    var diets: MutableList<String> = mutableListOf(),
    var occasions: MutableList<String> = mutableListOf(),
    var instructions: String = "",
    var analyzedInstructions: MutableList<AnalyzedInstruction> = mutableListOf(),
    var spoonacularSourceUrl: String = "",
    var isFavourite: Boolean = false
) : Parcelable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false

        val recipe = other as? Recipe
        return id == recipe?.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}

object RecipeEntry {
    const val RECIPES_OBJECT = "recipes"
    const val VEGETARIAN_KEY = "vegetarian"
    const val VEGAN_KEY = "vegan"
    const val GLUTEN_FREE_KEY = "glutenFree"
    const val DAIRY_FREE_KEY = "dairyFree"
    const val VERY_HEALTHY_KEY = "veryHealthy"
    const val CHEAP_KEY = "cheap"
    const val VERY_POPULAR_KEY = "veryPopular"
    const val SUSTAINABLE_KEY = "sustainable"
    const val LOW_FOD_MAP_KEY = "lowFodmap"
    const val WEIGHT_WATCHER_SMART_POINTS_KEY = "weightWatcherSmartPoints"
    const val GAPS_KEY = "gaps"
    const val PREPARATION_MINUTES_KEY = "preparationMinutes"
    const val COOKING_MINUTES_KEY = "cookingMinutes"
    const val AGGREGATE_LIKES_KEY = "aggregateLikes"
    const val HEALTH_SCORE_KEY = "healthScore"
    const val CREDITS_TEXT_KEY = "creditsText"
    const val SOURCE_NAME_KEY = "sourceName"
    const val PRICE_PER_SERVING_KEY = "pricePerServing"
    const val EXTENDED_INGREDIENTS_KEY = "extendedIngredients"
    const val ID_KEY = "id"
    const val TITLE_KEY = "title"
    const val READY_IN_MINUTES_KEY = "readyInMinutes"
    const val SERVINGS_KEY = "servings"
    const val SOURCE_URL_KEY = "sourceUrl"
    const val IMAGE_KEY = "image"
    const val IMAGE_TYPE_KEY = "imageType"
    const val SUMMARY_KEY = "summary"
    const val CUISINES_KEY = "cuisines"
    const val DISH_TYPES_KEY = "dishTypes"
    const val DIETS_KEY = "diets"
    const val OCCASIONS_KEY = "occasions"
    const val INSTRUCTIONS_KEY = "instructions"
    const val ANALYZED_INSTRUCTIONS_KEY = "analyzedInstructions"
    const val SPOONACULAR_SOURCE_URL_KEY = "spoonacularSourceUrl"
}
