package com.project.stockmanagement.stockmanagementapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.stockmanagement.stockmanagementapp.Model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
