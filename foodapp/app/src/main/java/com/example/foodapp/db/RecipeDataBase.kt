package com.example.foodapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.foodapp.dao.RecipeDAO
import com.example.foodapp.entity.RecipeEntity

@Database(entities = [RecipeEntity::class], version = 1)
abstract class RecipeDataBase: RoomDatabase() {
    abstract val recipeDAO: RecipeDAO

}