package com.project.stockmanagement.stockmanagementapp.Service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.stockmanagement.stockmanagementapp.Model.ProductCategory;
import com.project.stockmanagement.stockmanagementapp.Repository.ProductCategoryRepository;

import com.project.stockmanagement.stockmanagementapp.Service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    ProductCategoryRepository productRepository;

    @Override
    public List<ProductCategory> getAllCategories() {
        List<ProductCategory> products = new ArrayList<>();
        products = productRepository.findAll();

        return products;
    }

}
