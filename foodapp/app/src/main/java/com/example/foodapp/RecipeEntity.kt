package com.example.foodapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe_table")
class RecipeEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val image: String,
    val rating: Float,
    val description: String,
)