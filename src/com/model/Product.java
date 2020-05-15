package com.model;

public class Product {
    
    private int id;
    private String name;
    private String count;
    private String price;
    private String category;
    private String barcode;
    private String description;

    public Product(int id, String name, String count, String price, String category, String barcode, String description) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.category = category;
        this.barcode = barcode;
        this.description = description;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    
}
