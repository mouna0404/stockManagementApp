package com.project.stockmanagement.stockmanagementapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.stockmanagement.stockmanagementapp.Model.Supplier;

import com.project.stockmanagement.stockmanagementapp.Service.SupplierService;

@Controller
public class MainController {
    @Autowired
    SupplierService supplierService;

    @GetMapping("/index")
    public String loadIndexPage(Model model) {

        List<Supplier> Suppliers = supplierService.getAllSuppliers();
        model.addAttribute("suppliers", Suppliers);

        return "/index";
    }

}
