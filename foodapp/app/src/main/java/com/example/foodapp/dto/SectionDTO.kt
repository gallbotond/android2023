package com.example.foodapp.dto

import com.example.foodapp.model.SectionModel

data class SectionDTO(
    val id: Int,
    val name: String,
    val position: Int,
    val components: List<ComponentDTO>
) {
    fun toModel(): SectionModel {
        return SectionModel(
            id = this.id,
            name = this.name,
            position = this.position,
            components = this.components.map { it.toModel() }
        )
    }
}
