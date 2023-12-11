package com.example.foodapp.fragments

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.foodapp.R
import com.example.foodapp.model.RecipeModel
import java.util.concurrent.Executors

class RecipeDetailFragment : Fragment() {

    private lateinit var recipe: RecipeModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recipe = requireArguments().getParcelable("recipe")!!
        Log.i("GSON", "Recipe: $recipe")

        val titleTextView = view?.findViewById<TextView>(R.id.recipeTitle)
        val descriptionTextView = view?.findViewById<TextView>(R.id.recipeSummary)
        val imageView = view?.findViewById<androidx.appcompat.widget.AppCompatImageView>(R.id.recipeImage)

        titleTextView?.text = recipe.name
        descriptionTextView?.text = recipe.description

        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())
        var image: Bitmap? = null

        executor.execute {
            val url = recipe.image
            try {
                val `in` = java.net.URL(url).openStream()
                image = BitmapFactory.decodeStream(`in`)
                handler.post {
                    if (imageView != null) {
                        imageView.setImageBitmap(image)
                    }
                }
            } catch (e: Exception) {
                Log.e("Error Message", e.message.toString())
                e.printStackTrace()
            }
        }
    }
}