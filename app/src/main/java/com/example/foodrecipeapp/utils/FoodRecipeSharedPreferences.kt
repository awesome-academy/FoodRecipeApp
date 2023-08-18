package com.example.foodrecipeapp.utils

import android.content.Context

class FoodRecipeSharedPreferences(private val context: Context) {
    fun putBooleanValue(key: String, value: Boolean) {
        val sharedPreferences =
            context.getSharedPreferences(FOOD_RECIPE_SHARED_PREFERENCES, Context.MODE_PRIVATE)

        val editor = sharedPreferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun getBooleanValue(key: String): Boolean {
        val sharedPreferences =
            context.getSharedPreferences(FOOD_RECIPE_SHARED_PREFERENCES, Context.MODE_PRIVATE)

        return sharedPreferences.getBoolean(key, false)
    }

    fun putStringValue(key: String, value: String) {
        val sharedPreferences =
            context.getSharedPreferences(FOOD_RECIPE_SHARED_PREFERENCES, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getStringValue(key: String): String {
        val sharedPreferences =
            context.getSharedPreferences(FOOD_RECIPE_SHARED_PREFERENCES, Context.MODE_PRIVATE)

        return sharedPreferences.getString(key, "").toString()
    }

    companion object {
        private const val FOOD_RECIPE_SHARED_PREFERENCES = "FOOD_RECIPE_SHARED_PREFERENCES"
    }
}
