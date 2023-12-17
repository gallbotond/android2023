package com.example.foodapp.fragments

import RecipeRepository
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.RecipeDao
import com.example.foodapp.RecipeDataBase
import com.example.foodapp.adapter.RecipesAdapter
import com.example.foodapp.databinding.FragmentRecipesBinding
import com.example.foodapp.model.RecipeModel
import com.example.foodapp.view.RecipeListViewModel


class RecipesFragment : Fragment() {
    private lateinit var data: ArrayList<RecipeModel>
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecipesAdapter
    private lateinit var binding: FragmentRecipesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRecipesBinding.bind(view)

        val repository = RecipeRepository(RecipeDao())
        repository.fetchData(this.requireContext())

        data = repository.recipeModels

        recyclerView = view.findViewById(R.id.recipesRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        adapter = RecipesAdapter(data)
        recyclerView.adapter = adapter

        adapter.onItemClick = { recipe ->
//            Log.i("GSON", "Recipe: $recipe")
//            val bundle = Bundle()
//            bundle.putParcelable("recipe", recipe)
//
//            val recipeDetailFragment = RecipeDetailFragment()
//            recipeDetailFragment.arguments = bundle
//
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.myNavHostFragment, recipeDetailFragment)
//                .addToBackStack(null)
//                .commit()
//                val action = RecipesFragmentDirections.action_recipesFragment_to_recipeDetailsFragment(recipe)
//                findNavController().navigate(action)
        }
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

        val floatingActionButton: Button = view.findViewById(R.id.floatingActionButton)
        floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_recipesFragment_to_recipeAddFragment)
        }

        return view
    }

}