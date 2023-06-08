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

/**
 * Контроллер, поддерживающий страницу товаров.
 */
@Controller
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    /**
     * Товарный сервис, содержащий методы работы с товарами.
     */
    private final ProductService productService;

    /**
     * Поддерживает вывод списка товаров на страницу меню.
     *
     * @param model объект Model, являющийся списком названий товаров.
     *
     * @param title объект String, отражающий название товара.
     *
     * @return объект String, связывающий MVC с его визуальным представлением в templates.
     *
     */
    @GetMapping("/menu")
    public String products(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("products", productService.listProducts(title));
        return "products";
    }

    /**
     * Поддерживает отображение информации об опреденном товаре по его идентификатору.
     *
     * @param id объект Long,то есть идентификатор товара.
     *
     * @param model объект Model,то есть сам товар.
     *
     * @return объект String, связывающий MVC с его визуальным представлением в templates.
     */
    @GetMapping("/menu/product/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        Product product =  productService.getProductById(id);
        model.addAttribute("product", product);
        log.info("Found {}", product);

        return "product-info";
    }

    /**
     * Поддерживает создание нового товара.
     *
     * @param product объект Product, содержащий свю информацию о товаре, которая должна быть отображена.
     *
     * @return объект String, связывающий MVC с его визуальным представлением в templates.
     *
     * @throws IOException, если возникнут проблемы с сохранением товара.
     */
    @PostMapping("menu/product/create")
    public String createProduct(Product product) throws IOException {
        productService.saveProduct(product);
        return "redirect:/menu";
    }

    /**
     * Поддерживает удаление товара по его идентификатору.
     *
     * @param id объект Model,то есть сам товар.
     *
     * @return объект String, связывающий MVC с его визуальным представлением в templates.
     */
    @PostMapping("menu/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/menu";
    }
}