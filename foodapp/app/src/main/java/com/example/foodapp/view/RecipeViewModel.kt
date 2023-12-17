package com.example.foodapp.view

import RecipeRepository
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.foodapp.RecipeDataBase
import com.example.foodapp.RecipeEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipeViewModel(application: Application) : AndroidViewModel(application) {
    private val readAllData: LiveData<List<RecipeEntity>>
    private val repository: RecipeRepository

    init {
        val recipeDao = RecipeDataBase.getDatabase(application).recipeDao()
        repository = RecipeRepository(recipeDao)
        readAllData = repository.readAllData
    }

    fun addRecipe(recipeEntity: RecipeEntity) {
        viewModelScope.launch(Dispatchers.IO) { repository.addRecipe(recipeEntity) }
    }
}