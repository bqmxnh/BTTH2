package com.example.btth2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private List<Food> foodList;
    private Context context;

    public FoodAdapter(List<Food> foodList, Context context) {
        this.foodList = foodList;
        this.context = context;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_food, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food food = foodList.get(position);

        // Set food name
        holder.txtFoodName.setText(food.getName());

        // Set product count
        String productText = String.format("%d sản phẩm", food.getProductCount());
        holder.txtProductCount.setText(productText);

        // Set discount count
        String discountText = String.format("%d đang giảm giá", food.getDiscountCount());
        holder.txtDiscountCount.setText(discountText);

        // Set food image
        holder.imgFood.setImageResource(food.getImageResourceId());

        // Handle item click
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("foodId", food.getId());
            intent.putExtra("foodCategory", food.getName());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder {
        TextView txtFoodName, txtProductCount, txtDiscountCount;
        ImageView imgFood;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            txtFoodName = itemView.findViewById(R.id.txt_food_name);
            txtProductCount = itemView.findViewById(R.id.txt_product_count);
            txtDiscountCount = itemView.findViewById(R.id.txt_discount_count);
            imgFood = itemView.findViewById(R.id.img_food);
        }
    }
}