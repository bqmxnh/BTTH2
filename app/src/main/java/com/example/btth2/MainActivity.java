package com.example.btth2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FoodAdapter foodAdapter;
    List<Food> foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        foodList = getFoodList(); // Hàm tạo danh sách món ăn
        foodAdapter = new FoodAdapter(foodList, this);
        recyclerView.setAdapter(foodAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private List<Food> getFoodList() {
        // Thêm dữ liệu cho món ăn kèm theo ID của hình ảnh
        List<Food> foods = new ArrayList<>();
        foods.add(new Food(1, "Món mặn", 5, 5, R.drawable.mon_man));
        foods.add(new Food(2, "Món canh", 10, 10 , R.drawable.mon_canh));
        foods.add(new Food(3, "Món xào", 10, 10 , R.drawable.mon_xao));
        return foods;
    }

}
