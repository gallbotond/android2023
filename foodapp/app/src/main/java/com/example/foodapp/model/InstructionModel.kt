package com.example.foodapp.model

data class InstructionModel(
    val id: Int,
    val appliance: Void,
    val temperature: Int,
    val position: Int,
    val displayText: String,
    val startTime: Int,
    val endTime: Int,
)