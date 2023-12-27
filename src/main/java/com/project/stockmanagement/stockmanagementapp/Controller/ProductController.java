package com.project.stockmanagement.stockmanagementapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.stockmanagement.stockmanagementapp.Model.Product;
import com.project.stockmanagement.stockmanagementapp.Model.ProductCategory;
import com.project.stockmanagement.stockmanagementapp.Service.ProductCategoryService;
import com.project.stockmanagement.stockmanagementapp.Service.ProductService;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductCategoryService productCategoryService;

    @GetMapping("/products")
    public String getAllProducts(Model model) {

        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);

        return "products";
    }

    @GetMapping("/addProduct")
    public String loadAddProductPage(Model model) {
        /*
         * // Returns hardcoded data, a real world application would return from the
         * // database
         * List<Book> books = new ArrayList<Book>();
         * books.add(new Book(1, "Emma", "Jane Austen"));
         * books.add(new Book(2, "Harry Potter", "JK Rowling"));
         * books.add(new Book(3, "The Partner", "John Grisham"));
         * model.addAttribute("books", books);
         */
        List<ProductCategory> categories = productCategoryService.getAllCategories();
        model.addAttribute("categories", categories);

        return "add-product";
    }

    @PostMapping("/addProduct")
    public String addProduct(Model model, @ModelAttribute Product productData) {
        productService.createProduct(productData);
        // return "redirect:/products/";
        return "redirect:/products";
    }
}
