package com.example.btth2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    RecyclerView recyclerViewDetail;
    FoodDetailAdapter foodDetailAdapter;
    List<FoodDetail> foodDetailList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        recyclerViewDetail = findViewById(R.id.recyclerViewDetail);
        String foodCategory = getIntent().getStringExtra("foodCategory"); // Lấy category từ intent
        foodDetailList = getFoodDetailList(foodCategory); // Lấy danh sách chi tiết món ăn dựa trên category
        foodDetailAdapter = new FoodDetailAdapter(foodDetailList, this);
        recyclerViewDetail.setAdapter(foodDetailAdapter);
        recyclerViewDetail.setLayoutManager(new LinearLayoutManager(this));
    }

    private List<FoodDetail> getFoodDetailList(String category) {
        // Danh sách chi tiết món ăn kèm theo ID của hình ảnh và category
        List<FoodDetail> foodDetails = new ArrayList<>();
        foodDetails.add(new FoodDetail("Sườn nướng", "12000 đ", "15000 đ", 3, R.drawable.suon_nuong, "Món mặn"));
        foodDetails.add(new FoodDetail("Gà kho", "15000 đ", "15000 đ", 4, R.drawable.ga_kho, "Món mặn"));
        foodDetails.add(new FoodDetail("Thịt kho trứng", "12000 đ", "12000 đ", 3, R.drawable.thit_kho_trung, "Món mặn"));
        foodDetails.add(new FoodDetail("Canh rau", "8000 đ", "10000 đ", 5, R.drawable.canh_rau, "Món canh"));
        foodDetails.add(new FoodDetail("Canh thịt", "10000 đ", "12000 đ", 4, R.drawable.canh_thit, "Món canh"));
        foodDetails.add(new FoodDetail("Món xào 1", "12000 đ", "15000 đ", 3, R.drawable.mon_xao_1, "Món xào"));
        foodDetails.add(new FoodDetail("Món xào 2", "14000 đ", "17000 đ", 4, R.drawable.mon_xao_2, "Món xào"));

        // Lọc danh sách theo category
        List<FoodDetail> filteredDetails = new ArrayList<>();
        for (FoodDetail detail : foodDetails) {
            if (detail.getCategory().equals(category)) {
                filteredDetails.add(detail);
            }
        }
        return filteredDetails;
    }
}
