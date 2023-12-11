package com.example.foodapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.foodapp.entity.RecipeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDAO {
    @Upsert
    suspend fun upsertRecipe(recipe: RecipeEntity)

    @Delete
    suspend fun deleteRecipe(recipe: RecipeEntity)

    @Query("SELECT * FROM recipe_table ORDER BY name ASC")
    fun getRecipesOrderedByName(): Flow<List<RecipeEntity>>

    @Query("SELECT * FROM recipe_table ORDER BY rating DESC")
    fun getRecipesOrderedByRating(): Flow<List<RecipeEntity>>


}