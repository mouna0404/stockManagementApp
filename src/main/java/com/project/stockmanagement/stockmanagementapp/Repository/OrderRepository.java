package com.project.stockmanagement.stockmanagementapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.stockmanagement.stockmanagementapp.CustomInterface.IOrdredAmountByCategory;
import com.project.stockmanagement.stockmanagementapp.CustomInterface.IOrdredQuantityByCategory;
import com.project.stockmanagement.stockmanagementapp.Model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "SELECT c.category_name AS category,SUM(o.quantity * p.price) AS totalAmount "
            + "FROM  orders o "
            + "INNER JOIN products p ON p.product_id = o.product_id "
            + "INNER JOIN product_categories c ON p.category_id = c.product_category_id "
            + "GROUP BY c.category_name", nativeQuery = true)

    public List<IOrdredAmountByCategory> getOrdredAmountByCategory();

    @Query(value = "SELECT c.category_name AS category,SUM(o.quantity ) AS totalQuantity "
            + "FROM  orders o "
            + "INNER JOIN products p ON p.product_id = o.product_id "
            + "INNER JOIN product_categories c ON p.category_id = c.product_category_id "
            + "GROUP BY c.category_name", nativeQuery = true)

    public List<IOrdredQuantityByCategory> getOrdredQuantityByCategory();
}
