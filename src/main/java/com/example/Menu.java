package com.example;

import java.util.List;

public class Menu {
    List<Product> list;


    public Product choseProduct(int choice) {
        for (Product element:
             list) {
            if (element.id == choice) {
                return element;
            }
        }
        return null;
    }
    public void add(Product product) {
        list.add(product);
    }
}
