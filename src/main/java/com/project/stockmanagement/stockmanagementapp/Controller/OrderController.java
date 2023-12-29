package com.project.stockmanagement.stockmanagementapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.stockmanagement.stockmanagementapp.Model.Order;
import com.project.stockmanagement.stockmanagementapp.Model.Product;
import com.project.stockmanagement.stockmanagementapp.Model.Supplier;
import com.project.stockmanagement.stockmanagementapp.Service.OrderService;
import com.project.stockmanagement.stockmanagementapp.Service.ProductService;
import com.project.stockmanagement.stockmanagementapp.Service.SupplierService;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;
    @Autowired
    SupplierService supplierService;

    @GetMapping("/orders")
    public String getAllOrders(Model model) {

        List<Order> Orders = orderService.getAllOrders();
        model.addAttribute("orders", Orders);

        return "orders";
    }

    @GetMapping("/addOrder")
    public String loadAddOrderPage(Model model) {

        List<Supplier> suppliers = supplierService.getAllSuppliers();
        List<Product> products = productService.getAllProducts();
        model.addAttribute("suppliers", suppliers);
        model.addAttribute("products", products);

        return "add-order";
    }

    @PostMapping("/addOrder")
    public String addOrder(Model model, @ModelAttribute Order orderData) {
        orderService.createOrder(orderData);
        return "redirect:/orders";
    }

    @PostMapping("/deleteOrder")
    public String deleteOrder(Model model, @RequestParam Long orderId) {
        orderService.deleteOrder(orderId);

        return "redirect:/orders";
    }
}
