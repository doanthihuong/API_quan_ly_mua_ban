package com.example.api_quan_ly_mua_ban.service.impl;

import com.example.api_quan_ly_mua_ban.model.Product;

import com.example.api_quan_ly_mua_ban.repository.ProductRepository;
import com.example.api_quan_ly_mua_ban.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return  productRepository.save(product);

    }

    @Override
    public void remove(Long id) {
     productRepository.deleteById(id);
    }
}
