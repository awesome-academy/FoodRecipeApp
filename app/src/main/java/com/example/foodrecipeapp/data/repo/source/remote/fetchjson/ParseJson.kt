package com.example.foodrecipeapp.data.repo.source.remote.fetchjson

import com.example.foodrecipeapp.data.model.AnalyzedInstruction
import com.example.foodrecipeapp.data.model.AnalyzedInstructionEntry
import com.example.foodrecipeapp.data.model.Equipment
import com.example.foodrecipeapp.data.model.EquipmentEntry
import com.example.foodrecipeapp.data.model.ExtendedIngredient
import com.example.foodrecipeapp.data.model.ExtendedIngredientEntry
import com.example.foodrecipeapp.data.model.Ingredient
import com.example.foodrecipeapp.data.model.IngredientEntry
import com.example.foodrecipeapp.data.model.Length
import com.example.foodrecipeapp.data.model.LengthEntry
import com.example.foodrecipeapp.data.model.Measure
import com.example.foodrecipeapp.data.model.MeasureEntry
import com.example.foodrecipeapp.data.model.Metric
import com.example.foodrecipeapp.data.model.MetricEntry
import com.example.foodrecipeapp.data.model.Recipe
import com.example.foodrecipeapp.data.model.RecipeEntry
import com.example.foodrecipeapp.data.model.Step
import com.example.foodrecipeapp.data.model.StepEntry
import com.example.foodrecipeapp.data.model.Us
import com.example.foodrecipeapp.data.model.UsEntry
import org.json.JSONArray
import org.json.JSONObject

class ParseJson {
    fun recipesParseJson(jsonObject: JSONObject): Recipe {
        val recipe = Recipe()

        jsonObject.let {
            recipe.apply {
                vegetarian = it.getBoolean(RecipeEntry.VEGETARIAN_KEY)
                vegan = it.getBoolean(RecipeEntry.VEGAN_KEY)
                glutenFree = it.getBoolean(RecipeEntry.GLUTEN_FREE_KEY)
                dairyFree = it.getBoolean(RecipeEntry.DAIRY_FREE_KEY)
                veryHealthy = it.getBoolean(RecipeEntry.VERY_HEALTHY_KEY)
                cheap = it.getBoolean(RecipeEntry.CHEAP_KEY)
                veryPopular = it.getBoolean(RecipeEntry.VERY_POPULAR_KEY)
                sustainable = it.getBoolean(RecipeEntry.SUSTAINABLE_KEY)
                weightWatcherSmartPoints = it.getInt(RecipeEntry.WEIGHT_WATCHER_SMART_POINTS_KEY)
                gaps = it.getString(RecipeEntry.GAPS_KEY)
                lowFodmap = it.getBoolean(RecipeEntry.LOW_FOD_MAP_KEY)
                preparationMinutes = it.getInt(RecipeEntry.PREPARATION_MINUTES_KEY)
                cookingMinutes = it.getInt(RecipeEntry.COOKING_MINUTES_KEY)
                aggregateLikes = it.getInt(RecipeEntry.AGGREGATE_LIKES_KEY)
                healthScore = it.getDouble(RecipeEntry.HEALTH_SCORE_KEY)
                creditsText = it.getString(RecipeEntry.CREDITS_TEXT_KEY)
                sourceName = it.getString(RecipeEntry.SOURCE_NAME_KEY)
                pricePerServing = it.getDouble(RecipeEntry.PRICE_PER_SERVING_KEY)

                // Handle extended ingredients array
                extendedIngredients =
                    parseExtendedIngredients(it.getJSONArray(RecipeEntry.EXTENDED_INGREDIENTS_KEY))

                id = it.getInt(RecipeEntry.ID_KEY)
                title = it.getString(RecipeEntry.TITLE_KEY)
                readyInMinutes = it.getInt(RecipeEntry.READY_IN_MINUTES_KEY)
                servings = it.getInt(RecipeEntry.SERVINGS_KEY)
                sourceUrl = it.getString(RecipeEntry.SOURCE_URL_KEY)
                image = it.getString(RecipeEntry.IMAGE_KEY)
                imageType = it.getString(RecipeEntry.IMAGE_TYPE_KEY)
                summary = it.getString(RecipeEntry.SUMMARY_KEY)

                // Handle cuisines array
                cuisines = parseStringArray(it.getJSONArray(RecipeEntry.CUISINES_KEY))

                // Handle dish types array
                dishTypes = parseStringArray(it.getJSONArray(RecipeEntry.DISH_TYPES_KEY))

                // Handle diets array
                diets = parseStringArray(it.getJSONArray(RecipeEntry.DIETS_KEY))

                // Handle occasions array
                occasions = parseStringArray(it.getJSONArray(RecipeEntry.OCCASIONS_KEY))

                instructions = it.getString(RecipeEntry.INSTRUCTIONS_KEY)

                analyzedInstructions =
                    parseAnalyzedInstructions(it.getJSONArray(RecipeEntry.ANALYZED_INSTRUCTIONS_KEY))
                spoonacularSourceUrl = it.getString(RecipeEntry.SPOONACULAR_SOURCE_URL_KEY)
            }
        }

        return recipe
    }

    private fun parseExtendedIngredients(jsonArray: JSONArray): MutableList<ExtendedIngredient> {
        val extendedIngredients = mutableListOf<ExtendedIngredient>()

        // Handle extendedIngredients array
        for (i in 0 until jsonArray.length()) {
            val extendedIngredientJsonObject = jsonArray.getJSONObject(i)
            val measure =
                parseMeasure(extendedIngredientJsonObject.getJSONObject(ExtendedIngredientEntry.MEASURES_KEY))
            val meta =
                parseStringArray(extendedIngredientJsonObject.getJSONArray(ExtendedIngredientEntry.META_KEY))

            val extendedIngredient = ExtendedIngredient(
                id = extendedIngredientJsonObject.getInt(ExtendedIngredientEntry.ID_KEY),
                aisle = extendedIngredientJsonObject.getString(ExtendedIngredientEntry.AISLE_KEY),
                image = extendedIngredientJsonObject.getString(ExtendedIngredientEntry.IMAGE_KEY),
                consistency = extendedIngredientJsonObject.getString(ExtendedIngredientEntry.CONSISTENCY_KEY),
                name = extendedIngredientJsonObject.getString(ExtendedIngredientEntry.NAME_KEY),
                nameClean = extendedIngredientJsonObject.getString(ExtendedIngredientEntry.NAME_CLEAN_KEY),
                original = extendedIngredientJsonObject.getString(ExtendedIngredientEntry.ORIGINAL_KEY),
                originalName = extendedIngredientJsonObject.getString(ExtendedIngredientEntry.ORIGINAL_NAME_KEY),
                amount = extendedIngredientJsonObject.getDouble(ExtendedIngredientEntry.AMOUNT_KEY),
                unit = extendedIngredientJsonObject.getString(ExtendedIngredientEntry.UNIT_KEY),
                meta = meta,
                measure = measure
            )

            extendedIngredients.add(extendedIngredient)
        }

        return extendedIngredients
    }

    private fun parseMeasure(measureObject: JSONObject): Measure {
        val usObject = measureObject.getJSONObject(MeasureEntry.US_KEY)
        val metricObject = measureObject.getJSONObject(MeasureEntry.METRIC_KEY)

        return Measure(
            us = Us(
                amount = usObject.getDouble(UsEntry.AMOUNT_KEY),
                unitShort = usObject.getString(UsEntry.UNIT_SHORT_KEY),
                unitLong = usObject.getString(UsEntry.UNIT_LONG_KEY)
            ),
            metric = Metric(
                amount = metricObject.getDouble(MetricEntry.AMOUNT_KEY),
                unitShort = metricObject.getString(MetricEntry.UNIT_SHORT_KEY),
                unitLong = metricObject.getString(MetricEntry.UNIT_LONG_KEY)
            )
        )
    }

    private fun parseStringArray(jsonArray: JSONArray): MutableList<String> {
        val list = mutableListOf<String>()

        for (i in 0 until jsonArray.length()) {
            list.add(jsonArray.getString(i))
        }

        return list
    }

    private fun parseAnalyzedInstructions(jsonArray: JSONArray): MutableList<AnalyzedInstruction> {
        val analyzedInstructions = mutableListOf<AnalyzedInstruction>()

        for (i in 0 until jsonArray.length()) {
            val analyzedInstructionJsonObject = jsonArray.getJSONObject(i)
            val name = analyzedInstructionJsonObject.getString(AnalyzedInstructionEntry.NAME_KEY)
            val stepsJsonArray =
                analyzedInstructionJsonObject.getJSONArray(AnalyzedInstructionEntry.STEP_KEY)
            val steps = parseSteps(stepsJsonArray)

            val analyzedInstruction = AnalyzedInstruction(
                name = name,
                steps = steps
            )

            analyzedInstructions.add(analyzedInstruction)
        }

        return analyzedInstructions
    }

    private fun parseSteps(jsonArray: JSONArray): MutableList<Step> {
        val steps = mutableListOf<Step>()

        for (i in 0 until jsonArray.length()) {
            val stepJsonObject = jsonArray.getJSONObject(i)
            val ingredientsJsonArray = stepJsonObject.getJSONArray(StepEntry.INGREDIENTS_KEY)
            val equipmentsJsonArray = stepJsonObject.getJSONArray(StepEntry.EQUIPMENTS_KEY)

            val ingredients = parseIngredients(ingredientsJsonArray)
            val equipments = parseEquipments(equipmentsJsonArray)

            val step =
                stepJsonObject.optJSONObject(StepEntry.LENGTH_KEY)?.let { parseLength(it) }?.let {
                    Step(
                        number = stepJsonObject.getInt(StepEntry.NUMBER_KEY),
                        step = stepJsonObject.getString(StepEntry.STEP_KEY),
                        ingredients = ingredients,
                        equipments = equipments,
                        length = it
                    )
                }

            if (step != null) {
                steps.add(step)
            }
        }

        return steps
    }

    private fun parseIngredients(jsonArray: JSONArray): MutableList<Ingredient> {
        val ingredients = mutableListOf<Ingredient>()

        for (i in 0 until jsonArray.length()) {
            val ingredientJsonObject = jsonArray.getJSONObject(i)
            val ingredient = Ingredient(
                id = ingredientJsonObject.getInt(IngredientEntry.ID_KEY),
                name = ingredientJsonObject.getString(IngredientEntry.NAME_KEY),
                localizedName = ingredientJsonObject.getString(IngredientEntry.LOCALIZED_NAME_KEY),
                image = ingredientJsonObject.getString(IngredientEntry.IMAGE_KEY)
            )
            ingredients.add(ingredient)
        }

        return ingredients
    }

    private fun parseEquipments(jsonArray: JSONArray): MutableList<Equipment> {
        val equipments = mutableListOf<Equipment>()

        for (i in 0 until jsonArray.length()) {
            val equipmentJsonObject = jsonArray.getJSONObject(i)
            val equipment = Equipment(
                id = equipmentJsonObject.getInt(EquipmentEntry.ID_KEY),
                name = equipmentJsonObject.getString(EquipmentEntry.NAME_KEY),
                localizedName = equipmentJsonObject.getString(EquipmentEntry.LOCALIZED_NAME_KEY),
                image = equipmentJsonObject.getString(EquipmentEntry.IMAGE_KEY)
            )
            equipments.add(equipment)
        }

        return equipments
    }

    private fun parseLength(lengthObject: JSONObject): Length {
        return Length(
            number = lengthObject.getInt(LengthEntry.NUMBER_KEY),
            unit = lengthObject.getString(LengthEntry.UNIT_KEY)
        )
    }
}
