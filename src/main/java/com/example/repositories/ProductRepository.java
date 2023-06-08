package com.example.repositories;

import com.example.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Репозиторий товаров, используемый для поиска товаров в базе данных.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Ищет товар по его названию.
     *
     * @param title строка, содержащая название товара.
     *
     * @return объект список объектов Product, то есть названия всех товаров, содержащихся в базе.
     *
     */
    List<Product> findByTitle(String title);
}
