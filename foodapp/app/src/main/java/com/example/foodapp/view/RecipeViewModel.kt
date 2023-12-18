package com.example.foodapp.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.foodapp.database.RecipeDatabase
import com.example.foodapp.database.RecipesRepositoryDB
import com.example.foodapp.model.RecipeModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipeViewModel(application: Application): AndroidViewModel(application) {
    private val repository: RecipesRepositoryDB

    val allRecipes: LiveData<List<RecipeModel>>

    init {
        val dao = RecipeDatabase.getDatabase(application).getRecipeDao()
        repository = RecipesRepositoryDB(dao)
        allRecipes = repository.allRecipes
    }

    fun deleteRecipe(recipe: RecipeModel) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteRecipe(recipe)
    }

    fun insertRecipe(recipe: RecipeModel) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertRecipe(recipe)
    }

    fun update(recipe: RecipeModel) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(recipe)
    }
}