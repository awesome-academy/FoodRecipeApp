package com.example.foodrecipeapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Recipe(
    @Suppress("UnusedPrivateMember")
    private val vegetarian: Boolean,
    @Suppress("UnusedPrivateMember")
    private val vegan: Boolean,
    @Suppress("UnusedPrivateMember")
    private val glutenFree: Boolean,
    @Suppress("UnusedPrivateMember")
    private val dairyFree: Boolean,
    @Suppress("UnusedPrivateMember")
    private val veryHealthy: Boolean,
    @Suppress("UnusedPrivateMember")
    private val cheap: Boolean,
    @Suppress("UnusedPrivateMember")
    private val veryPopular: Boolean,
    @Suppress("UnusedPrivateMember")
    private val sustainable: Boolean,
    @Suppress("UnusedPrivateMember")
    private val weightWatcherSmartPoints: Int,
    @Suppress("UnusedPrivateMember")
    private val gaps: String,
    @Suppress("UnusedPrivateMember")
    private val lowFodmap: Boolean,
    @Suppress("UnusedPrivateMember")
    private val aggregateLikes: Int,
    @Suppress("UnusedPrivateMember")
    private val spoonacularScore: Double,
    @Suppress("UnusedPrivateMember")
    private val healthScore: Double,
    @Suppress("UnusedPrivateMember")
    private val creditsText: String,
    @Suppress("UnusedPrivateMember")
    private val license: String,
    @Suppress("UnusedPrivateMember")
    private val sourceName: String,
    @Suppress("UnusedPrivateMember")
    private val pricePerServing: Double,
    @Suppress("UnusedPrivateMember")
    private val id: Int,
    @Suppress("UnusedPrivateMember")
    private val title: String,
    @Suppress("UnusedPrivateMember")
    private val readyInMinutes: Int,
    @Suppress("UnusedPrivateMember")
    private val servings: Int,
    @Suppress("UnusedPrivateMember")
    private val sourceUrl: String,
    @Suppress("UnusedPrivateMember")
    private val image: String,
    @Suppress("UnusedPrivateMember")
    private val imageType: String,
    @Suppress("UnusedPrivateMember")
    private val summary: String,
    @Suppress("UnusedPrivateMember")
    private val cuisines: @RawValue ArrayList<Any>,
    @Suppress("UnusedPrivateMember")
    private val dishTypes: ArrayList<String>,
    @Suppress("UnusedPrivateMember")
    private val diets: ArrayList<String>,
    @Suppress("UnusedPrivateMember")
    private val occasions: ArrayList<String>,
    @Suppress("UnusedPrivateMember")
    private val instructions: String,
    @Suppress("UnusedPrivateMember")
    private val analyzedInstructions: @RawValue ArrayList<AnalyzedInstruction>,
    @Suppress("UnusedPrivateMember")
    private val originalId: @RawValue Any,
    @Suppress("UnusedPrivateMember")
    private val spoonacularSourceUrl: String
) : Parcelable

object RecipeEntry {
    const val SEARCH_RECIPES = "complexSearch"
    const val SEARCH_RECIPES_BY_NUTRIENTS = "findByNutrients"
    const val SEARCH_RECIPES_BY_INGREDIENTS = "findByIngredients"
    const val GET_RECIPE_INFORMATION = "information"
    const val GET_RECIPE_INFORMATION_BULK = "informationBulk"
    const val GET_SIMILAR_RECIPES = "similar"
    const val GET_RANDOM_RECIPES = "random"
    const val AUTOCOMPLETE_RECIPE_SEARCH = "autocomplete"
    const val TASTE_BY_ID = "tasteWidget.json"
    const val EQUIPMENT_BY_ID = "equipmentWidget.json"
    const val PRICE_BREAKDOWN_BY_ID = "priceBreakdownWidget.json"
    const val INGREDIENTS_BY_ID = "ingredientWidget.json"
    const val NUTRITION_BY_ID = "nutritionWidget.json"
    const val GET_ANALYZED_RECIPE_INSTRUCTIONS = "analyzedInstructions"
    const val EXTRACT_RECIPE_FROM_WEBSITE = "extract"
    const val ANALYZE_RECIPE = "analyze"
    const val SUMMARIZE_RECIPE = "summary"
    const val ANALYZE_RECIPE_INSTRUCTIONS = "analyzeInstructions"
    const val CLASSIFY_CUISINE = "cuisine"
    const val ANALYZE_RECIPE_SEARCH_QUERY = "queries/analyze"
    const val GUESS_NUTRITION_BY_DISH_NAME = "guessNutrition"
}
