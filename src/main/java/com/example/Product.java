package com.example;

public abstract class Product {
    int id;
    String brand;
    int cost;
    String color;
    boolean inStock;

    public Product(int id, String brand, int cost, String color, boolean inStock) {
        this.id = id;
        this.brand = brand;
        this.cost = cost;
        this.color = color;
        this.inStock = inStock;
    }
}
