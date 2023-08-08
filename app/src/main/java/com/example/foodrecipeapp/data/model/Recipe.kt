package com.example.foodrecipeapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Recipe(
    private val vegetarian: Boolean,
    private val vegan: Boolean,
    private val glutenFree: Boolean,
    private val dairyFree: Boolean,
    private val veryHealthy: Boolean,
    private val cheap: Boolean,
    private val veryPopular: Boolean,
    private val sustainable: Boolean,
    private val weightWatcherSmartPoints: Int,
    private val gaps: String,
    private val lowFodmap: Boolean,
    private val aggregateLikes: Int,
    private val spoonacularScore: Double,
    private val healthScore: Double,
    private val creditsText: String,
    private val license: String,
    private val sourceName: String,
    private val pricePerServing: Double,
    private val id: Int,
    private val title: String,
    private val readyInMinutes: Int,
    private val servings: Int,
    private val sourceUrl: String,
    private val image: String,
    private val imageType: String,
    private val summary: String,
    private val cuisines: @RawValue ArrayList<Any>,
    private val dishTypes: ArrayList<String>,
    private val diets: ArrayList<String>,
    private val occasions: ArrayList<String>,
    private val instructions: String,
    private val analyzedInstructions: @RawValue ArrayList<AnalyzedInstruction>,
    private val originalId: @RawValue Any,
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
