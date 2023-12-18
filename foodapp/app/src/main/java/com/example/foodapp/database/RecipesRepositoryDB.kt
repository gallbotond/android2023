package com.example.foodapp.database

import androidx.lifecycle.LiveData
import com.example.foodapp.model.RecipeModel

class RecipesRepositoryDB(private val dao: RecipeDao) {
    val allRecipes: LiveData<List<RecipeModel>> = dao.getAllRecipes()

    suspend fun insertRecipe(recipe: RecipeModel) {
        dao.insertRecipe(recipe)
    }

    suspend fun deleteRecipe(recipe: RecipeModel) {
        dao.deleteRecipe(recipe)
    }

    suspend fun update(recipe: RecipeModel) {
        dao.update(recipe.id, recipe.name, recipe.image, recipe.description, recipe.rating)
    }
}