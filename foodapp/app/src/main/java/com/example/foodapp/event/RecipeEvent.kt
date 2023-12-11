package com.example.foodapp.event

import com.example.foodapp.SortType
import com.example.foodapp.entity.RecipeEntity

sealed interface RecipeEvent{
    object SaveRecipe: RecipeEvent
    data class DeleteRecipe(val recipe: RecipeEntity): RecipeEvent
    data class setTitle(val title: String): RecipeEvent
    data class setDescription(val description: String): RecipeEvent
    data class setImg(val img: String): RecipeEvent
    object ShowDialog: RecipeEvent
    object HideDialog: RecipeEvent
    data class SortRecipes(val sortType: SortType): RecipeEvent
}