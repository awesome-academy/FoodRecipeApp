package com.example.foodrecipeapp.utils

import android.content.Context

class DataLocalManager {
    private lateinit var foodRecipeSharedPreferences: FoodRecipeSharedPreferences

    companion object {
        private const val SHARED_PREFERENCES_KEY_FIRST_INSTALL = "FIRST_INSTALL"

        private var instance: DataLocalManager? = null

        fun init(context: Context) {
            instance = DataLocalManager()
            instance?.foodRecipeSharedPreferences = FoodRecipeSharedPreferences(context)
        }

        private fun getInstance(): DataLocalManager {
            if (instance == null) {
                instance = DataLocalManager()
            }
            return instance as DataLocalManager
        }

        fun setFirstInstalled(isFirstTimeInstalled: Boolean) {
            getInstance().foodRecipeSharedPreferences.putBooleanValue(
                SHARED_PREFERENCES_KEY_FIRST_INSTALL,
                isFirstTimeInstalled
            )
        }

        fun getFirstInstalled(): Boolean {
            return getInstance().foodRecipeSharedPreferences.getBooleanValue(
                SHARED_PREFERENCES_KEY_FIRST_INSTALL
            )
        }
    }
}
