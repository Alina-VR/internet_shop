//package com.example;
//
//import com.example.controllers.ProductController;
//import com.example.models.Product;
//import com.example.repositories.ProductRepository;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import com.example.services.ProductService;
//import org.junit.jupiter.api.BeforeEach;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.query.FluentQuery;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Function;
//
//@ExtendWith(MockitoExtension.class)
//public class ProductServiceTests {
//    private static final long ID = 1L;
//    @Mock
//    private ProductRepository productRepository;
//
//    @Mock
//    private ProductService productService;
//
//    @InjectMocks
//    private ProductController productController;
//
//    @BeforeEach
//    void setUp() { productRepository = new ProductRepository();
//    }
//
//    @Test
//    public void findProductByID(){
//        final Product product = mock(Product.class);
//        when(product.getId()).thenReturn(ID);
//
//        try {
//            productController.createProduct(product);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        final Optional<Product> actual = productRepository.findById(ID);
//
//        assertNotNull(actual);
//        assertEquals(product, actual);
//    }
//
//}
