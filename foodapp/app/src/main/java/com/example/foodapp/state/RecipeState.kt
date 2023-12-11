package com.example.foodapp.state

import com.example.foodapp.SortType
import com.example.foodapp.entity.RecipeEntity

class RecipeState (
    val recipes: List<RecipeEntity> = emptyList(),
    val title: String = "",
    val description: String = "",
    val img: String = "",
    val isAddingRecipe: Boolean = false,
    val sortType: SortType = SortType.TITLE,
)