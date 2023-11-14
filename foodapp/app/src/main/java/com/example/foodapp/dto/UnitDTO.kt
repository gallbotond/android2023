package com.example.foodapp.dto

data class UnitDTO(
    val id: Int,
    val name: String,
    val system: String,
    val abbreviation: String,
    val displayPlural: String,
    val displaySingular: String
) {
    fun toModel(): com.example.foodapp.model.UnitModel {
        return com.example.foodapp.model.UnitModel(
            id = this.id,
            name = this.name,
            system = this.system,
            abbreviation = this.abbreviation,
            displayPlural = this.displayPlural,
            displaySingular = this.displaySingular
        )
    }
}
