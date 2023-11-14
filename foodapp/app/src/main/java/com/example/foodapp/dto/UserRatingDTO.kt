package com.example.foodapp.dto

import com.example.foodapp.model.UserRatingModel

data class UserRatingDTO(
    val countPositive: Int,
    val countNegative: Int,
    val score: Float
) {
    fun toModel(): UserRatingModel {
        return UserRatingModel(
            countPositive = this.countPositive,
            countNegative = this.countNegative,
            score = this.score
        )
    }
}
