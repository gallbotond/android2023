package com.example.foodapp.model

data class SectionModel(
    val id: Int,
    val name: String,
    val position: Int,
    val components: List<ComponentModel>
)
