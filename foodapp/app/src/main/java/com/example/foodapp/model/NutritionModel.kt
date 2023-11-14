package com.example.foodapp.model

import java.util.Date

data class NutritionModel(
    val id: Int,
    val updatedAt: Date,
    val fiber: Int,
    val protein: Int,
    val fat: Int,
    val calories: Int,
    val carbohydrates: Int,
    val sugar: Int,
)
