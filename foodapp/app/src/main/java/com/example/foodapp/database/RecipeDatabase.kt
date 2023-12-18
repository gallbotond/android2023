package com.example.foodapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.foodapp.model.RecipeModel
import com.example.foodapp.utilities.DATABASE_NAME

@Database(entities = arrayOf(RecipeModel::class), version = 1, exportSchema = false)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun getRecipeDao(): RecipeDao

    companion object {
        @Volatile
        private var INSTANCE: RecipeDatabase? = null

        fun getDatabase(context: Context): RecipeDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RecipeDatabase::class.java,
                    DATABASE_NAME
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}