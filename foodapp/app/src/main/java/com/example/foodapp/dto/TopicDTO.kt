package com.example.foodapp.dto

import com.example.foodapp.model.TopicModel

data class TopicDTO(
    val id: Int,
    val name: String,
    val slug: String
) {
    fun toModel(): TopicModel {
        return TopicModel(
            id = this.id,
            name = this.name,
            slug = this.slug
        )
    }
}
