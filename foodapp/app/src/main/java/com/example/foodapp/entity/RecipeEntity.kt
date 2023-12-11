package com.example.foodapp.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "recipe_table")
data class RecipeEntity(
    val name: String,
    val image: String,
    val description: String,
    val rating: Float,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
)
