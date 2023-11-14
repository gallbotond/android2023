package com.example.foodapp.dto

import com.example.foodapp.model.InstructionModel

data class InstructionDTO(
    val id: Int,
    val appliance: Void,
    val temperature: Int,
    val position: Int,
    val displayText: String,
    val startTime: Int,
    val endTime: Int,
) {
    fun toModel(): InstructionModel {
        return InstructionModel(
            id = this.id,
            appliance = this.appliance,
            temperature = this.temperature,
            position = this.position,
            displayText = this.displayText,
            startTime = this.startTime,
            endTime = this.endTime
        )
    }
}