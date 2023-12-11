package com.example.foodapp.model

data class RecipeModel(
    val id: Int,
    val name: String,
    val image: String,
    val description: String,
//    val tags: List<TagModel>,
    val rating: Float,
//    val credits: List<CreditModel>,
//    val sections: List<SectionModel>,
//    val topics: List<TopicModel>,
//    val instructions: List<InstructionModel>,
//    val nutrition: NutritionModel,
)
