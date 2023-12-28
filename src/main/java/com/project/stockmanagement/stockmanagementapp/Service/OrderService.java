package com.project.stockmanagement.stockmanagementapp.Service;

import java.util.List;

import com.project.stockmanagement.stockmanagementapp.Model.Order;

public interface OrderService {
    List<Order> getAllOrders();

    void createOrder(Order newOrder);

    void deleteOrder(Long OrderId);

}
