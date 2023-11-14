package com.example.foodapp.dto

import com.example.foodapp.model.RecipeModel

data class RecipeDTO(
    val id: Int,
    val name: String,
    val image: String,
    val description: String,
    val tags: List<TagDTO>,
    val userRatings: UserRatingDTO,
    val credits: List<CreditDTO>,
    val sections: List<SectionDTO>,
    val topics: List<TopicDTO>,
    val instructions: List<InstructionDTO>,
    val nutrition: NutritionDTO,
) {
    fun toModel(): RecipeModel {
        return RecipeModel(
            id = this.id,
            name = this.name,
            image = this.image,
            description = this.description,
            tags = this.tags.map { it.toModel() },
            userRatings = this.userRatings.toModel(),
            credits = this.credits.map { it.toModel() },
            sections = this.sections.map { it.toModel() },
            topics = this.topics.map { it.toModel() },
            instructions = this.instructions.map { it.toModel() },
            nutrition = this.nutrition.toModel()
        )
    }
}
