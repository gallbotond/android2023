package com.example.foodapp.dto

import com.example.foodapp.model.CreditModel

data class CreditDTO(
    val id: Int,
    val name: String,
    val type: String,
) {
    fun toModel(): CreditModel {
        return CreditModel(
            id = this.id,
            name = this.name,
            type = this.type
        )
    }
}
