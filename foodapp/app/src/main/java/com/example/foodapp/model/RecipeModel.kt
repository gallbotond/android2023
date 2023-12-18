package com.example.foodapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes_table")
data class RecipeModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "recipe_name")
    val name: String,
    @ColumnInfo(name = "recipe_image")
    val image: String,
    @ColumnInfo(name = "recipe_description")
    val description: String,
    @ColumnInfo(name = "recipe_rating")
    val rating: Float,
)