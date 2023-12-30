package com.project.stockmanagement.stockmanagementapp.Service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.stockmanagement.stockmanagementapp.Model.Product;
import com.project.stockmanagement.stockmanagementapp.Repository.ProductRepository;
import com.project.stockmanagement.stockmanagementapp.Service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        products = productRepository.findAll();

        return products;
    }

    @Override
    public Product getProductById(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow();

        return product;
    }

    @Override
    public void createProduct(Product newProduct) {
        productRepository.save(newProduct);

    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);

    }
}
