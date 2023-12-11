package com.example.foodapp.view

import RecipeRepository
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodapp.model.InstructionModel
import com.example.foodapp.model.RecipeModel

class RecipeListViewModel(private val repository: RecipeRepository) : ViewModel() {

    // LiveData to hold the list of InstructionModels
    private val _recipeModels = MutableLiveData<List<RecipeModel>>()
    val recipeModels: LiveData<List<RecipeModel>> = _recipeModels

    // Load all recipes using the repository
    fun loadRecipeData(context: Context) {
//        _recipeModels.value = repository.getAllRecipes(context)
    }

    fun loadInstructionData(requireContext: Context) {
        TODO("Not yet implemented")
    }
}