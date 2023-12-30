package com.project.stockmanagement.stockmanagementapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.stockmanagement.stockmanagementapp.CustomInterface.IOrdredAmountByCategory;
import com.project.stockmanagement.stockmanagementapp.CustomInterface.IOrdredQuantityByCategory;
import com.project.stockmanagement.stockmanagementapp.CustomInterface.ITopSupplier;
import com.project.stockmanagement.stockmanagementapp.Service.OrderService;

@Controller
public class MainController {
    @Autowired
    OrderService orderService;

    @GetMapping("/")
    public String loadIndexPage(Model model) {

        List<IOrdredAmountByCategory> data1 = orderService.getOrdredAmountByCategory();
        List<IOrdredQuantityByCategory> data2 = orderService.getOrdredQuantityByCategory();
        ITopSupplier data3 = orderService.getTopSupplier();
        IOrdredQuantityByCategory data4 = orderService.getTopCategory();
        model.addAttribute("data1", data1);
        model.addAttribute("data2", data2);
        model.addAttribute("data3", data3);
        model.addAttribute("data4", data4);
        return "/index";
    }

}
