package com.project.stockmanagement.stockmanagementapp.Service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.stockmanagement.stockmanagementapp.CustomInterface.IOrdredAmountByCategory;
import com.project.stockmanagement.stockmanagementapp.CustomInterface.IOrdredQuantityByCategory;
import com.project.stockmanagement.stockmanagementapp.CustomInterface.ITopSupplier;
import com.project.stockmanagement.stockmanagementapp.Model.Order;
import com.project.stockmanagement.stockmanagementapp.Repository.OrderRepository;
import com.project.stockmanagement.stockmanagementapp.Service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        List<Order> Orders = new ArrayList<>();
        Orders = orderRepository.findAll();

        return Orders;
    }

    @Override
    public void createOrder(Order newOrder) {
        orderRepository.save(newOrder);

    }

    @Override
    public void deleteOrder(Long OrderId) {
        orderRepository.deleteById(OrderId);

    }

    @Override
    public List<IOrdredAmountByCategory> getOrdredAmountByCategory() {
        List<IOrdredAmountByCategory> summaryData = new ArrayList<>();
        summaryData = orderRepository.getOrdredAmountByCategory();

        return summaryData;
    }

    @Override
    public List<IOrdredQuantityByCategory> getOrdredQuantityByCategory() {
        List<IOrdredQuantityByCategory> summaryData = new ArrayList<>();
        summaryData = orderRepository.getOrdredQuantityByCategory();
        return summaryData;
    }

    @Override
    public ITopSupplier getTopSupplier() {
        ITopSupplier topSupplier = orderRepository.getTopSupplier();
        return topSupplier;
    }

    @Override
    public IOrdredQuantityByCategory getTopCategory() {
        IOrdredQuantityByCategory topCategory = orderRepository.getTopCategory();
        return topCategory;
    }

}
