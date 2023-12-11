package com.example.foodapp.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp.SortType
import com.example.foodapp.dao.RecipeDAO
import com.example.foodapp.event.RecipeEvent
import com.example.foodapp.state.RecipeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RecipeViewModel(
    private val dao: RecipeDAO,
): ViewModel() {
    private val _sortType = MutableLiveData(SortType.TITLE)
    private val _state = MutableStateFlow(RecipeState())

    fun onEvent(event: RecipeEvent) {
        when(event) {
            is RecipeEvent.DeleteRecipe -> {
                viewModelScope.launch {
                    dao.deleteRecipe(event.recipe)
                }
            }
            RecipeEvent.HideDialog -> {
                _state.update { it.copy(isAddingRecipe = false) }
            }
            RecipeEvent.SaveRecipe -> TODO()
            RecipeEvent.ShowDialog -> TODO()
            is RecipeEvent.SortRecipes -> TODO()
            is RecipeEvent.setDescription -> TODO()
            is RecipeEvent.setImg -> TODO()
            is RecipeEvent.setTitle -> TODO()
        }
    }
}