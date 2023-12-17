package com.example.foodapp.data

import androidx.lifecycle.LiveData

class RecipeRepositoryDB(private val recipeDao: RecipeDao) {

    val readAllData: LiveData<List<Recipe>> = recipeDao.readAllData()

    suspend fun addRecipe(recipe: Recipe) {
        recipeDao.addRecipe(recipe)
    }
}