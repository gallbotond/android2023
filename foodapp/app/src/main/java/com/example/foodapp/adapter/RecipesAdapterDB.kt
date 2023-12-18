package com.example.foodapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.model.RecipeModel

class RecipesAdapterDB(private val context: Context, val listener: RecipeItemClickListener) : RecyclerView.Adapter<RecipesAdapterDB.RecipesViewHolderDB>() {
    private val RecipesList= ArrayList<RecipeModel>()
    private val fullList= ArrayList<RecipeModel>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecipesAdapterDB.RecipesViewHolderDB {
        return RecipesViewHolderDB(
            LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecipesAdapterDB.RecipesViewHolderDB, position: Int) {
        val currentItem = RecipesList[position]
        holder.name.text = currentItem.name
        holder.image.text = currentItem.image
        holder.rating.text = currentItem.rating.toString()

        holder.recipes_layout.setOnClickListener {
            listener.onRecipeItemClick(RecipesList[holder.adapterPosition])
        }

        holder.recipes_layout.setOnLongClickListener {
            listener.onLongItemClicked(RecipesList[holder.adapterPosition], holder.recipes_layout as CardView)
            true
        }
    }

    override fun getItemCount(): Int {
        return RecipesList.size
    }

    fun updateList(newList: List<RecipeModel>) {
        RecipesList.clear()
        RecipesList.addAll(newList)
        fullList.clear()
        fullList.addAll(newList)
        notifyDataSetChanged()
    }

    inner class RecipesViewHolderDB (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recipes_layout = itemView.findViewById<View>(R.id.recipeListItem)
        val name = itemView.findViewById<TextView>(R.id.recipeTitleTextView)
        val image = itemView.findViewById<TextView>(R.id.recipeImageView)
        val rating = itemView.findViewById<TextView>(R.id.recipeRankTextView)
    }

    interface RecipeItemClickListener {
        fun onRecipeItemClick(recipe: RecipeModel)
        fun onLongItemClicked(recipe: RecipeModel, cardView: CardView)
    }
}
