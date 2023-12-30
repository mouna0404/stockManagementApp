package com.project.stockmanagement.stockmanagementapp.Service;

import java.util.List;

import com.project.stockmanagement.stockmanagementapp.CustomInterface.IOrdredAmountByCategory;
import com.project.stockmanagement.stockmanagementapp.CustomInterface.IOrdredQuantityByCategory;
import com.project.stockmanagement.stockmanagementapp.CustomInterface.ITopSupplier;
import com.project.stockmanagement.stockmanagementapp.Model.Order;

public interface OrderService {
    List<Order> getAllOrders();

    void createOrder(Order newOrder);

    void deleteOrder(Long OrderId);

    List<IOrdredAmountByCategory> getOrdredAmountByCategory();

    List<IOrdredQuantityByCategory> getOrdredQuantityByCategory();

    ITopSupplier getTopSupplier();

    IOrdredQuantityByCategory getTopCategory();

}
