package com.project.stockmanagement.stockmanagementapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.stockmanagement.stockmanagementapp.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
