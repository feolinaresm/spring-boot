package com.store.domain;

public class ProductDTO {
    private int id;
    private String dName;
    private int dCategoryId;
    private double price;
    private int dQuantity;
    private boolean active;
    private CategoryDTO dCategory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public int getdCategoryId() {
        return dCategoryId;
    }

    public void setdCategoryId(int dCategoryId) {
        this.dCategoryId = dCategoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getdQuantity() {
        return dQuantity;
    }

    public void setdQuantity(int dQuantity) {
        this.dQuantity = dQuantity;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CategoryDTO getdCategory() {
        return dCategory;
    }

    public void setdCategory(CategoryDTO dCategory) {
        this.dCategory = dCategory;
    }
}
