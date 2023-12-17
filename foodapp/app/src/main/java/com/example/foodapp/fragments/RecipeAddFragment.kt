package com.example.foodapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.foodapp.R
import com.example.foodapp.RecipeEntity
import com.example.foodapp.view.RecipeViewModel

class RecipeAddFragment : Fragment() {
    private lateinit var mRecipeViewModel: RecipeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recipe_add, container, false)

        mRecipeViewModel = ViewModelProvider(this).get(RecipeViewModel::class.java)

        val button: Button = view.findViewById(R.id.addRecipe)
        button.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val title: EditText = view?.findViewById(R.id.title)!!
        val image: EditText = view?.findViewById(R.id.imageUrl)!!
        val desctiption: EditText = view?.findViewById(R.id.description)!!

        val titleText = title.text.toString()
        val imageText = image.text.toString()
        val descriptionText = desctiption.text.toString()

        val recipe = RecipeEntity(
            0,
            titleText,
            imageText,
            1.0f,
            descriptionText
        )

        mRecipeViewModel.addRecipe(recipe)
        Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()

        findNavController().navigate(R.id.action_recipeAddFragment_to_recipesFragment)
    }

    companion object {
        fun newInstance(param1: String?, param2: String?): RecipeAddFragment {
            val fragment = RecipeAddFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}