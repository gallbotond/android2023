package com.example.foodapp.fragments

import RecipeRepository
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.adapter.RecipesAdapter
import com.example.foodapp.databinding.FragmentRecipesBinding
import com.example.foodapp.model.RecipeModel
import com.example.foodapp.view.RecipeListViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class RecipesFragment : Fragment() {
    private lateinit var data: ArrayList<RecipeModel>
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecipesAdapter
    private lateinit var binding: FragmentRecipesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRecipesBinding.bind(view)
        val repository = RecipeRepository()
        repository.fetchData(this.requireContext())

        data = repository.recipeModels

        recyclerView = view.findViewById(R.id.recipesRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        adapter = RecipesAdapter(data)
        recyclerView.adapter = adapter

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recipes, container, false)

        val addRecipeButton = view.findViewById<FloatingActionButton>(R.id.floatingActionButton)
        addRecipeButton.setOnClickListener {
            findNavController().navigate(R.id.action_recipesFragment_to_addFragment)
        }

        return view
    }

}