package com.project.stockmanagement.stockmanagementapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.stockmanagement.stockmanagementapp.Model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
