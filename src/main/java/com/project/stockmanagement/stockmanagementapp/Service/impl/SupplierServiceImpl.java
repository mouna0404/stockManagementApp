package com.project.stockmanagement.stockmanagementapp.Service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.stockmanagement.stockmanagementapp.Model.Supplier;
import com.project.stockmanagement.stockmanagementapp.Repository.SupplierRepository;
import com.project.stockmanagement.stockmanagementapp.Service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    @Override
    public List<Supplier> getAllSuppliers() {
        List<Supplier> suppliers = new ArrayList<>();
        suppliers = supplierRepository.findAll();

        return suppliers;
    }

}
