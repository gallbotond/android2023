package com.example.foodapp.db

import androidx.lifecycle.LiveData

class RecipeRepository(private val recipeDao: RecipeDao) {
    val readAllData: LiveData<List<RecipeEntity>> = recipeDao.getAllRecipes()

    suspend fun addRecipe(recipe: RecipeEntity) {
        recipeDao.insertRecipe(recipe)
    }
}