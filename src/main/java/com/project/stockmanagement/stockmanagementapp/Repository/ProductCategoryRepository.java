package com.project.stockmanagement.stockmanagementapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.stockmanagement.stockmanagementapp.Model.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
