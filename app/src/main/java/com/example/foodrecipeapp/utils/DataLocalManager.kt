package com.example.foodrecipeapp.utils

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.foodrecipeapp.data.model.Recipe
import com.example.foodrecipeapp.data.repo.source.remote.fetchjson.ParseJsonToObject
import com.example.foodrecipeapp.data.repo.source.remote.fetchjson.ParseObjectToJson
import org.json.JSONArray
import org.json.JSONObject

class DataLocalManager {
    private lateinit var foodRecipeSharedPreferences: FoodRecipeSharedPreferences

    companion object {
        private const val SHARED_PREFERENCES_KEY_FIRST_INSTALL = "FIRST_INSTALL"
        private const val SHARED_PREFERENCES_KEY_LIST_FAVOURITE_RECIPE = "LIST_FAVOURITE_RECIPE"

        private var instance: DataLocalManager? = null

        val listFavouritesRecipes: MutableList<Recipe> by lazy {
            getListFavouriteRecipe()
        }

        val favouriteRecipesLiveData: MutableLiveData<MutableList<Recipe>> by lazy {
            MutableLiveData<MutableList<Recipe>>(listFavouritesRecipes)
        }

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

        private fun setListFavouriteRecipe(listFavouritesRecipes: MutableList<Recipe>) {
            val jsonArray = JSONArray()

            for (recipe in listFavouritesRecipes) {
                jsonArray.put(ParseObjectToJson().parseObjectToJsonObject(recipe))
            }

            getInstance().foodRecipeSharedPreferences.putStringValue(
                SHARED_PREFERENCES_KEY_LIST_FAVOURITE_RECIPE,
                jsonArray.toString()
            )
        }

        private fun getListFavouriteRecipe(): MutableList<Recipe> {
            val listFavouritesRecipes = mutableListOf<Recipe>()

            val strJsonArray = getInstance().foodRecipeSharedPreferences.getStringValue(
                SHARED_PREFERENCES_KEY_LIST_FAVOURITE_RECIPE
            )

            Log.e("getListFavouriteRecipe", strJsonArray)

            if (strJsonArray.isNotEmpty()) {
                val jsonArray = JSONArray(strJsonArray)
                var jsonObject: JSONObject
                var favouriteRecipe: Recipe

                for (i in 0 until jsonArray.length()) {
                    jsonObject = jsonArray.getJSONObject(i)
                    favouriteRecipe = ParseJsonToObject().parseJsonToRecipeObject(jsonObject)
                    listFavouritesRecipes.add(favouriteRecipe)
                }
            }

            return listFavouritesRecipes
        }

        fun addFavouriteRecipe(recipe: Recipe) {
            val listFavourites = getListFavouriteRecipe()
            if (!listFavourites.contains(recipe)) {
                listFavourites.add(recipe)
                setListFavouriteRecipe(listFavourites)
                favouriteRecipesLiveData.value = listFavourites
            }
        }

        fun removeFavouriteRecipe(recipe: Recipe) {
            val listFavourites = getListFavouriteRecipe()
            if (listFavourites.contains(recipe)) {
                listFavourites.remove(recipe)
                setListFavouriteRecipe(listFavourites)
                favouriteRecipesLiveData.value = listFavourites
            }
        }
    }
}
