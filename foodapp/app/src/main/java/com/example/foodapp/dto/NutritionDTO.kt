package com.example.foodapp.dto

import com.example.foodapp.model.NutritionModel
import java.util.Date

data class NutritionDTO(
    val id: Int,
    val updatedAt: Date,
    val fiber: Int,
    val protein: Int,
    val fat: Int,
    val calories: Int,
    val carbohydrates: Int,
    val sugar: Int,
) {
    fun toModel(): NutritionModel {
        return NutritionModel(
            id = this.id,
            updatedAt = this.updatedAt,
            fiber = this.fiber,
            protein = this.protein,
            fat = this.fat,
            calories = this.calories,
            carbohydrates = this.carbohydrates,
            sugar = this.sugar
        )
    }
}
