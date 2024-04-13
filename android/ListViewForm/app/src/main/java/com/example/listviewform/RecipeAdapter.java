package com.example.listviewform;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    private final String[] recipeNames = {"Pasta", "Maggi", "Cake", "Pancake", "Pizza", "Burgers", "Fries"};
    private final String[] recipeDurations = {"30 mins", "2 mins", "45 mins", "10 mins", "60 mins", "45 mins", "30 mins"};
    private final int[] imageIds = {R.drawable.pasta, R.drawable.maggi, R.drawable.cake, R.drawable.pancake, R.drawable.pizza, R.drawable.burger, R.drawable.fries};

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_item, parent, false);
        return new RecipeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        holder.recipeName.setText(recipeNames[position]);
        holder.recipeDuration.setText(recipeDurations[position]);
        holder.recipeImage.setImageResource(imageIds[position]);
    }

    @Override
    public int getItemCount() {
        return recipeNames.length;
    }

    static class RecipeViewHolder extends RecyclerView.ViewHolder {
        TextView recipeName, recipeDuration;
        ImageView recipeImage;

        RecipeViewHolder(View itemView) {
            super(itemView);
            recipeName = itemView.findViewById(R.id.recipeName);
            recipeDuration = itemView.findViewById(R.id.recipeDuration);
            recipeImage = itemView.findViewById(R.id.recipeImage);
        }
    }
}
