package com.example.foodapp.dto

import com.example.foodapp.model.IngredientModel
import java.util.Date

data class IngredientDTO(
    val id: Int,
    val name: String,
    val createdAt: Date,
    val updatedAt: Date,
    val displaySingular: String,
    val displayPlural: String,
) {
    fun toModel(): IngredientModel {
        return IngredientModel(
            id = this.id,
            name = this.name,
            createdAt = this.createdAt,
            updatedAt = this.updatedAt,
            displaySingular = this.displaySingular,
            displayPlural = this.displayPlural
        )
    }
}
