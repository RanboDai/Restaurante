package com.example.appderestaurante.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appderestaurante.databinding.FoodItemBinding;
import com.example.appderestaurante.model.Food;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    private final ArrayList<Food>foodList;
    private final Context context;

    public FoodAdapter(ArrayList<Food> foodList, Context context) {
        this.foodList = foodList;
        this.context = context;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FoodItemBinding listItem;
        listItem = FoodItemBinding.inflate(LayoutInflater.from(context),parent,false);
        return new FoodViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        // Configuração da imagem de comida
        holder.binding.imgFood.setBackgroundResource(foodList.get(position).getImgFood());

        // Configuração do nome da comida
        holder.binding.txtFoodName.setText(foodList.get(position).getFoodName());

        // Configuração da descrição da comida
        holder.binding.txtFoodDescription.setText(foodList.get(position).getFoodDescription());

        // Configuração do preço da comida
        holder.binding.txtPrice.setText(foodList.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public static class  FoodViewHolder extends RecyclerView.ViewHolder{

        FoodItemBinding binding;

        public FoodViewHolder(FoodItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }

}
