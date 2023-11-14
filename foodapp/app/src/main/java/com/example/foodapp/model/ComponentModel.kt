package com.example.foodapp.model

import com.example.foodapp.dto.MeasurementDTO

data class ComponentModel(
    val id: Int,
    val rawText: String,
    val extraComment: String,
    val position: Int,
    val measurements: List<MeasurementDTO>,
    val ingredient: IngredientModel,
)
