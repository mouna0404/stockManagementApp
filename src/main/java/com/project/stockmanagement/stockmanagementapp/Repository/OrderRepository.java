package com.project.stockmanagement.stockmanagementapp.Repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.stockmanagement.stockmanagementapp.CustomInterface.IOrdredAmountByCategory;
import com.project.stockmanagement.stockmanagementapp.CustomInterface.IOrdredQuantityByCategory;
import com.project.stockmanagement.stockmanagementapp.CustomInterface.ITopSupplier;
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

        @Query(value = "SELECT s.first_name||' '||s.last_name AS supplier, COUNT(o.order_id) AS nbOrder "
                        + "FROM  orders o "
                        + "INNER JOIN suppliers s ON s.supplier_id = o.supplier_id "
                        + "WHERE DATE_PART('month', o.order_date) = DATE_PART('month', now()) "
                        + "AND   DATE_PART('year', o.order_date) = DATE_PART('year', now()) "
                        + "GROUP BY supplier "
                        + "ORDER BY nbOrder DESC "
                        + "LIMIT 1", nativeQuery = true)

        public ITopSupplier getTopSupplier();

        @Query(value = "SELECT c.category_name AS category,SUM(o.quantity ) AS totalQuantity "
                        + "FROM  orders o "
                        + "INNER JOIN products p ON p.product_id = o.product_id "
                        + "INNER JOIN product_categories c ON p.category_id = c.product_category_id "
                        + "WHERE DATE_PART('month', o.order_date) = DATE_PART('month', now()) "
                        + "AND   DATE_PART('year', o.order_date) = DATE_PART('year', now()) "
                        + "GROUP BY c.category_name "
                        + "ORDER BY totalQuantity DESC "
                        + "LIMIT 1", nativeQuery = true)

        public IOrdredQuantityByCategory getTopCategory();

}
