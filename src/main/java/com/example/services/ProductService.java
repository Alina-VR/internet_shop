package com.example.services;

import com.example.models.Product;
import com.example.models.User;
import com.example.repositories.ProductRepository;
import com.example.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Товарный сервис, содержащий методы работы с товарами.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    /**
     * Выводит список товаров.
     *
     * @param title объект String, то есть название товар.
     *
     * @return список товаров.
     */
    public List<Product> listProducts(String title){
        if (title != null) return productRepository.findByTitle(title);
       return productRepository.findAll();
    }

    /**
     * Сохраняет товар.
     *
     * @param product объект Product, то есть товар.
     */
    public void saveProduct(Product product) {
        log.info("Saving new Product. Title: {}; Author email: {}", product.getTitle(), product.getSeller());
        Product productFromDb = productRepository.save(product);
        productRepository.save(product);
    }

    /**
     * Удаляет товар.
     *
     * @param id объект Long, то есть идентификатор товара.
     */
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    /**
     * Получает товар по идентификатору.
     *
     * @param id объект Long, то есть идентификатор товара.
     *
     * @return product объект Product, то есть товар.
     */
    public Product getProductById(Long id){
       return  productRepository.findById(id).orElse(null);
    }
}

