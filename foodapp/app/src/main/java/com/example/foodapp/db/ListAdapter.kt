package com.example.foodapp.db

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import java.util.concurrent.Executors

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var recipeList = emptyList<RecipeEntity>()
    class MyViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.recipeTitleTextView)
        val image: ImageView = itemView.findViewById(R.id.recipeImageView)
        val rating: TextView = itemView.findViewById(R.id.recipeRankTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = recipeList[position]
        holder.title.text = currentItem.name
        holder.rating.text = currentItem.recipeRating.toString()

        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())
        var image: Bitmap? = null

        executor.execute {
            val url = currentItem.image
            try {
                val `in` = java.net.URL(url).openStream()
                image = BitmapFactory.decodeStream(`in`)
                handler.post {
                    holder.image.setImageBitmap(image)
                }
            } catch (e: Exception) {
                Log.e("Error Message", e.message.toString())
                e.printStackTrace()
            }
        }

        holder.itemView.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Opening: ${currentItem.name}",
                Toast.LENGTH_SHORT
            ).show()
            // navigate to recipe detail fragment passing in the recipe
            Navigation.findNavController(it).navigate(R.id.action_recipesFragment_to_recipeDetailsFragment, Bundle().apply { putParcelable("recipe", currentItem)  })
        }
    }

    fun setData(recipe: List<RecipeEntity>) {
        this.recipeList = recipe
        notifyDataSetChanged()
    }
}