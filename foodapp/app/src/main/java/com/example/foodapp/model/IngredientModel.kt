package com.example.foodapp.model

import java.util.Date

data class IngredientModel(
    val id: Int,
    val name: String,
    val createdAt: Date,
    val updatedAt: Date,
    val displaySingular: String,
    val displayPlural: String,
)
