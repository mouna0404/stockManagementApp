package com.project.stockmanagement.stockmanagementapp.Service;

import java.util.List;

import com.project.stockmanagement.stockmanagementapp.Model.Product;

public interface ProductService {
    List<Product> getAllProducts();

    void createProduct(Product newProduct);

    void deleteProduct(Long productId);

    Product getProductById(Long productId);

}
