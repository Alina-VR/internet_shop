package com.example.controllers;

import com.example.models.Product;
import com.example.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.security.Principal;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/menu")
    public String products(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("products", productService.listProducts(title));
        return "products";
    }

    @GetMapping("/menu/product/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        Product product =  productService.getProductById(id);
        model.addAttribute("product", product);
        log.info("Found {}", product);

        return "product-info";
    }

    @PostMapping("menu/product/create")
    public String createProduct(Product product, Principal principal) throws IOException {
//        productService.saveProduct(principal, product);
        productService.saveProduct(product);
        return "redirect:/menu";
    }

    @PostMapping("menu/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/menu";
    }
}