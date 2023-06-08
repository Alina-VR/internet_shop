package com.example;

import com.example.models.Product;
import com.example.repositories.ProductRepository;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

//public class ProductServiceTests {
//    private static final long ID = 1L;
//    private ProductRepository productRepository;
//
//    @BeforeEach
//    void setUp() {
//        productRepository = new ProductRepository() {
//
//            @Override
//            public List<Product> findAll() {
//                return null;
//            }
//
//            @Override
//            public List<Product> findAll(final Sort sort) {
//                return null;
//            }
//
//            @Override
//            public Page<Product> findAll(final Pageable pageable) {
//                return null;
//            }
//
//            @Override
//            public List<Product> findAllById(final Iterable<Long> longs) {
//                return null;
//            }
//
//            @Override
//            public long count() {
//                return 0;
//            }
//
//            @Override
//            public void deleteById(final Long aLong) {
//
//            }
//
//            @Override
//            public void delete(final Product entity) {
//
//            }
//
//            @Override
//            public void deleteAllById(final Iterable<? extends Long> longs) {
//
//            }
//
//            @Override
//            public void deleteAll(final Iterable<? extends Product> entities) {
//
//            }
//
//            @Override
//            public void deleteAll() {
//
//            }
//
//            @Override
//            public <S extends Product> S save(final S entity) {
//                return null;
//            }
//
//            @Override
//            public <S extends Product> List<S> saveAll(final Iterable<S> entities) {
//                return null;
//            }
//
//            @Override
//            public Optional<Product> findById(final Long aLong) {
//                return Optional.empty();
//            }
//
//            @Override
//            public boolean existsById(final Long aLong) {
//                return false;
//            }
//
//            @Override
//            public void flush() {
//
//            }
//
//            @Override
//            public <S extends Product> S saveAndFlush(final S entity) {
//                return null;
//            }
//
//            @Override
//            public <S extends Product> List<S> saveAllAndFlush(final Iterable<S> entities) {
//                return null;
//            }
//
//            @Override
//            public void deleteAllInBatch(final Iterable<Product> entities) {
//
//            }
//
//            @Override
//            public void deleteAllByIdInBatch(final Iterable<Long> longs) {
//
//            }
//
//            @Override
//            public void deleteAllInBatch() {
//
//            }
//
//            @Override
//            public Product getOne(final Long aLong) {
//                return null;
//            }
//
//            @Override
//            public Product getById(final Long aLong) {
//                return null;
//            }
//
//            @Override
//            public Product getReferenceById(final Long aLong) {
//                return null;
//            }
//
//            @Override
//            public <S extends Product> Optional<S> findOne(final Example<S> example) {
//                return Optional.empty();
//            }
//
//            @Override
//            public <S extends Product> List<S> findAll(final Example<S> example) {
//                return null;
//            }
//
//            @Override
//            public <S extends Product> List<S> findAll(final Example<S> example, final Sort sort) {
//                return null;
//            }
//
//            @Override
//            public <S extends Product> Page<S> findAll(final Example<S> example, final Pageable pageable) {
//                return null;
//            }
//
//            @Override
//            public <S extends Product> long count(final Example<S> example) {
//                return 0;
//            }
//
//            @Override
//            public <S extends Product> boolean exists(final Example<S> example) {
//                return false;
//            }
//
//            @Override
//            public <S extends Product, R> R findBy(final Example<S> example,
//                                                   final Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
//                return null;
//            }
//
//            @Override
//            public List<Product> findByTitle(final String title) {
//                return null;
//            }
//        };
//    }
//
//    @Test
//    public void findProductByID(){
//        final Product product = mock(Product.class);
//        when(product.getId()).thenReturn(ID);
//
//        productRepository.save(product);
//        final Optional<Product> actual = productRepository.findById(ID);
//
//        assertNotNull(actual);
//        assertEquals(product, actual);
//    }
//
//}
