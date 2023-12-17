package com.example.foodapp.adapter

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.model.RecipeModel
import java.util.concurrent.Executors

class RecipesAdapter (private val recipes: ArrayList<RecipeModel>) :
    RecyclerView.Adapter<RecipesAdapter.RecipeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return RecipeViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val currentItem = recipes[position]
        Log.i("GSON", "Recipe: $currentItem")
        holder.title.text = currentItem.name
        holder.rating.text = currentItem.rating.toString()

//        holder.image.setImageResource(R.drawable.ic_launcher_background)
        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())
        var image: Bitmap? = null

        executor.execute {
            val url = currentItem.image
            try {
                val `in` = java.net.URL(url).openStream()
                image = BitmapFactory.decodeStream(`in`)
                handler.post{
                    holder.image.setImageBitmap(image)
                }
            }catch (e: Exception){
                Log.e("Error Message", e.message.toString())
                e.printStackTrace()
            }
        }
    }
    class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.recipeTitleTextView)
        val image: ImageView = itemView.findViewById(R.id.recipeImageView)
        val rating: TextView = itemView.findViewById(R.id.recipeRankTextView)
    }
}