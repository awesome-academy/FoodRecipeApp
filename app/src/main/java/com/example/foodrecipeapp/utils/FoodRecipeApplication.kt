package com.example.foodrecipeapp.utils

import android.app.Application

class FoodRecipeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DataLocalManager.init(applicationContext)
    }
}
