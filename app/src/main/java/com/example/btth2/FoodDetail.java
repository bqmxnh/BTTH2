package com.example.btth2;

public class FoodDetail {
    private String name;
    private String price;
    private String oldPrice;
    private float rating;
    private int imageResourceId;
    private String category; // Thêm thuộc tính category

    public FoodDetail(String name, String price, String oldPrice, float rating, int imageResourceId, String category) {
        this.name = name;
        this.price = price;
        this.oldPrice = oldPrice;
        this.rating = rating;
        this.imageResourceId = imageResourceId;
        this.category = category; // Cập nhật constructor
    }

    // Các getter đã có
    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public float getRating() {
        return rating;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    // Getter cho category
    public String getCategory() {
        return category;
    }
}
