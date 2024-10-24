package com.example.btth2;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodDetailAdapter extends RecyclerView.Adapter<FoodDetailAdapter.FoodDetailViewHolder> {

    private List<FoodDetail> foodDetailList;
    private Context context;

    public FoodDetailAdapter(List<FoodDetail> foodDetailList, Context context) {
        this.foodDetailList = foodDetailList;
        this.context = context;
    }

    @NonNull
    @Override
    public FoodDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_food_detail, parent, false);
        return new FoodDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodDetailViewHolder holder, int position) {
        FoodDetail foodDetail = foodDetailList.get(position);
        holder.txtFoodDetailName.setText(foodDetail.getName());
        holder.txtFoodDetailPrice.setText(foodDetail.getPrice());
        holder.txtFoodDetailOldPrice.setText(foodDetail.getOldPrice());

        // Add strikethrough effect to the old price
        holder.txtFoodDetailOldPrice.setPaintFlags(holder.txtFoodDetailOldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        holder.ratingBar.setRating(foodDetail.getRating());
        holder.imgFoodDetail.setImageResource(foodDetail.getImageResourceId()); // Hiển thị hình ảnh chi tiết món ăn
    }



    @Override
    public int getItemCount() {
        return foodDetailList.size();
    }

    public static class FoodDetailViewHolder extends RecyclerView.ViewHolder {
        TextView txtFoodDetailName, txtFoodDetailPrice, txtFoodDetailOldPrice;
        RatingBar ratingBar;
        ImageView imgFoodDetail;

        public FoodDetailViewHolder(@NonNull View itemView) {
            super(itemView);
            txtFoodDetailName = itemView.findViewById(R.id.txt_food_detail_name);
            txtFoodDetailPrice = itemView.findViewById(R.id.txt_food_detail_price);
            txtFoodDetailOldPrice = itemView.findViewById(R.id.txt_food_detail_old_price);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            imgFoodDetail = itemView.findViewById(R.id.img_food_detail);
        }
    }
}

