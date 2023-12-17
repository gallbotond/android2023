package com.example.foodapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.foodapp.R
import com.example.foodapp.data.Recipe
import com.example.foodapp.data.RecipeViewModel

class RecipeAddFragment : Fragment() {

    private lateinit var mRecipeViewModel: RecipeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recipe_add, container, false)
        val addButton = view.findViewById<View>(R.id.addRecipeButton)

        mRecipeViewModel = ViewModelProvider(this)[RecipeViewModel::class.java]

        addButton.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
//        Toast.makeText(requireContext(), "Recipe added!", Toast.LENGTH_SHORT).show()
        val recipeName = view?.findViewById<View>(R.id.recipeNameEditText)?.toString()
        val recipeDescription = view?.findViewById<View>(R.id.recipeDescriptionEditText)?.toString()
        val recipeImage = view?.findViewById<View>(R.id.recipeImageEditText)?.toString()
        val recipeRating = view?.findViewById<View>(R.id.recipeRatingEditText)?.toString()

        Log.i("RecipeAddFragment", "recipeName: $recipeName")

        if (recipeName != null && recipeDescription != null && recipeImage != null && recipeRating != null) {
            mRecipeViewModel.addRecipe(Recipe(0, recipeName, recipeImage, recipeDescription, recipeRating.toFloat()))
            Toast.makeText(requireContext(), "Recipe added!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_recipeAddFragment_to_recipesFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_SHORT).show()
        }
    }
}