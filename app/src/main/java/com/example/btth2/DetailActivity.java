package com.example.btth2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    RecyclerView recyclerViewDetail;
    FoodDetailAdapter foodDetailAdapter;
    List<FoodDetail> foodDetailList;
    ImageView imgBack; // Declare back button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Set up Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); // Hide default title if needed

        imgBack = findViewById(R.id.img_back); // Initialize back button

        // Back button functionality
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Navigate back to previous activity
            }
        });

        recyclerViewDetail = findViewById(R.id.recyclerViewDetail);
        String foodCategory = getIntent().getStringExtra("foodCategory");
        foodDetailList = getFoodDetailList(foodCategory);
        foodDetailAdapter = new FoodDetailAdapter(foodDetailList, this);
        recyclerViewDetail.setAdapter(foodDetailAdapter);
        recyclerViewDetail.setLayoutManager(new LinearLayoutManager(this));
    }

    private List<FoodDetail> getFoodDetailList(String category) {
        // Your existing method for getting food details
        List<FoodDetail> foodDetails = new ArrayList<>();
        foodDetails.add(new FoodDetail("Sườn nướng", "12000 đ", "15000 đ", 3, R.drawable.suon_nuong, "Món mặn"));
        foodDetails.add(new FoodDetail("Gà kho", "15000 đ", "15000 đ", 4, R.drawable.ga_kho, "Món mặn"));
        foodDetails.add(new FoodDetail("Thịt kho trứng", "12000 đ", "12000 đ", 3, R.drawable.thit_kho_trung, "Món mặn"));
        foodDetails.add(new FoodDetail("Canh rau", "8000 đ", "10000 đ", 5, R.drawable.canh_rau, "Món canh"));
        foodDetails.add(new FoodDetail("Canh thịt", "10000 đ", "12000 đ", 4, R.drawable.canh_thit, "Món canh"));
        foodDetails.add(new FoodDetail("Món xào 1", "12000 đ", "15000 đ", 3, R.drawable.mon_xao_1, "Món xào"));
        foodDetails.add(new FoodDetail("Món xào 2", "14000 đ", "17000 đ", 4, R.drawable.mon_xao_2, "Món xào"));

        List<FoodDetail> filteredDetails = new ArrayList<>();
        for (FoodDetail detail : foodDetails) {
            if (detail.getCategory().equals(category)) {
                filteredDetails.add(detail);
            }
        }
        return filteredDetails;
    }
}
