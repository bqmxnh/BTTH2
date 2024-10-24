package com.example.btth2;

public class Food {
    private int id;
    private String name;
    private int productCount;  // Số sản phẩm
    private int discountCount; // Số sản phẩm đang giảm giá
    private int imageResourceId;

    public Food(int id, String name, int productCount, int discountCount, int imageResourceId) {
        this.id = id;
        this.name = name;
        this.productCount = productCount;
        this.discountCount = discountCount;
        this.imageResourceId = imageResourceId;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getProductCount() {
        return productCount;
    }

    public int getDiscountCount() {
        return discountCount;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public void setDiscountCount(int discountCount) {
        this.discountCount = discountCount;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }
}