package com.example.foodapp.fragments

import RecipeRepository
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.foodapp.R
import com.example.foodapp.db.RecipeEntity
import com.example.foodapp.db.RecipeViewModel

class AddFragment : Fragment() {
    private lateinit var mRecipeViewModel: RecipeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mRecipeViewModel = ViewModelProvider(this).get(RecipeViewModel::class.java)

        val addBtn = view.findViewById<Button>(R.id.add)
        addBtn.setOnClickListener {
            insertDataToDatabase()
        }

//        val addAllButton = view.findViewById<Button>(R.id.addAll)
//        addAllButton.setOnClickListener {
//            RecipeRepository().fetchData(this.requireContext()).forEach {
//                val recipe = RecipeEntity(0, it.name, it.image, it.description, it.rating)
//                mRecipeViewModel.addRecipe(recipe)
//                Log.i("GSON", "Added ${it.name}")
//            }
//        }

        return view
    }

    private fun insertDataToDatabase() {
        val recipeName = view?.findViewById<EditText>(R.id.name)?.text.toString()
        val recipeDescription = view?.findViewById<EditText>(R.id.desc)?.text.toString()
        val recipeImg = view?.findViewById<EditText>(R.id.url)?.text.toString()

        val recipeRatingString = view?.findViewById<EditText>(R.id.rate)?.text.toString()
        val recipeRating = if (recipeRatingString.isEmpty()) {
            // Handle the case where the string is empty. For example, set a default value:
            0.0f
        } else {
            // If the string is not empty, parse it as a float:
            recipeRatingString.toFloat()
        }

        if(inputCheck(recipeName, recipeDescription, recipeImg, recipeRating)) {
            // Create Recipe Object
            val recipe = RecipeEntity(0, recipeName, recipeImg, recipeDescription, recipeRating)
            // Add Data to Database
            mRecipeViewModel.addRecipe(recipe)
            Toast.makeText(context, "Successfully added " + recipe.name, Toast.LENGTH_SHORT).show()
            // Navigate Back
            requireActivity().supportFragmentManager.popBackStack()
        } else {
            Toast.makeText(context, "Please fill out all fields.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(
        recipeName: String,
        recipeDescription: String,
        recipeImg: String,
        recipeRating: Float
    ): Boolean {
        val empty = !(recipeName.isEmpty() || recipeDescription.isEmpty() || recipeImg.isEmpty() || recipeRating.toString().isEmpty())
        Log.i("GSON", "Empty: $empty")
        return empty
    }

}