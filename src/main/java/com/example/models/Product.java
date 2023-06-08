package com.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.persistence.*;

/**
 * Класс товаров.
 */
@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    /**
     * Идентификатор товара.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    /**
     * Название товара.
     */
    @Column(name = "title")
    private String title;

    /**
     * Описание товара.
     */
    @Column(name = "description")
    private String description;

    /**
     * Цена товара.
     */
    @Column(name = "price")
    private int price;

    /**
     * Продавец.
     */
    @Column(name = "seller")
    private String seller;

}
