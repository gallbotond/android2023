package com.example.foodapp.dto

import com.example.foodapp.model.ComponentModel

data class ComponentDTO(
    val id: Int,
    val rawText: String,
    val extraComment: String,
    val position: Int,
    val measurements: List<MeasurementDTO>,
    val ingredient: IngredientDTO,
) {
    fun toModel(): ComponentModel {
        return ComponentModel(
            id = this.id,
            rawText = this.rawText,
            extraComment = this.extraComment,
            position = this.position,
            measurements = this.measurements,
            ingredient = this.ingredient.toModel()
        )
    }
}
