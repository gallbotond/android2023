package com.example.foodapp.dto

import com.example.foodapp.model.TagModel

data class TagDTO(
    val id: Int,
    val name: String,
    val displayName: String,
    val type: String,
    val rootTagType: String
) {
    fun toModel(): TagModel {
        return TagModel(
            id = this.id,
            name = this.name,
            displayName = this.displayName,
            type = this.type,
            rootTagType = this.rootTagType
        )
    }
}
