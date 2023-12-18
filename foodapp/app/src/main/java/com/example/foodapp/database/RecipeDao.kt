package com.example.foodapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foodapp.model.RecipeModel

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipe(recipe: RecipeModel)
    @Delete
    suspend fun deleteRecipe(recipe: RecipeModel)
    @Query("SELECT * FROM recipes_table order by id ASC")
    fun getAllRecipes(): LiveData<List<RecipeModel>>
    @Query("UPDATE recipes_table SET recipe_name = :name, recipe_image = :image, recipe_description = :description, recipe_rating = :rating WHERE id = :id")
    suspend fun update(id: Int?, name: String?, image: String?, description: String?, rating: Float?)
}