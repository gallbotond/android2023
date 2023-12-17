package com.example.foodapp.service

import android.content.Context
import android.util.Log
import com.example.foodapp.RecipeEntity
import com.example.foodapp.model.RecipeModel
import org.json.JSONArray
import java.io.InputStream

class Util {
    fun fetchData(context: Context) {
        Log.i("GSON", "Context: $context")
        val inputStream: InputStream = context.assets.open("recipes.json")
        val json = inputStream.bufferedReader().use { it.readText() }
//        val buffer = ByteArray(inputStream.available())
//        Log.i("GSON", "Buffer created, length: ${buffer.size}")
        val jsonArray = JSONArray(json)
        Log.i("GSON", "JSON Array read")

        var name: String
        var image: String
        var description: String
        var rating: Float

        for (i in 0..<jsonArray.length()) {
//            Log.i("GSON", "JSON Array: ${jsonArray[i]}")
//            Log.i("GSON", "JSON Array: ${jsonArray.getJSONObject(i).getString("name")}")

            name = jsonArray.getJSONObject(i).getString("name")
            image = jsonArray.getJSONObject(i).getString("image")
            description = jsonArray.getJSONObject(i).getString("description")
            rating = jsonArray.getJSONObject(i).getDouble("rating").toFloat()

            val recipe = RecipeEntity(
                0,
                name,
                image,
                rating,
                description
            )


        }
    }
}