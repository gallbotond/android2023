package com.example.foodapp.dto

import com.example.foodapp.model.MeasurementModel

data class MeasurementDTO(
    val id: Int,
    val unit: UnitDTO,
    val quantity: Int,
) {
    fun toModel(): MeasurementModel {
        return MeasurementModel(
            id = this.id,
            unit = this.unit.toModel(),
            quantity = this.quantity
        )
    }
}
