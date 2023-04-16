package com.example.services;

import com.example.models.Product;
import com.example.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private List<Product> products = new ArrayList<>();
    private long ID = 0;

    public List<Product> listProducts(String title){
        if (title != null) return productRepository.findByTitle(title);
       return productRepository.findAll();
    }

    public void saveProduct(Product product){
        log.info("Saving new {}", product);
        products.add(product);
        productRepository.save(product);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public Product getProductById(Long id){
       return (Product) productRepository.findById(id).orElse(null);
    }
}

