package com.galvanize.controllers;

import com.galvanize.services.OrderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {


    OrderService orderService;


    public HomeController (OrderService orderService){
        this.orderService = orderService;
    }

    @RequestMapping("/home")
    public Model showHomePage(Model model){
        model.addAttribute("orders", orderService.getAllOrders());
        return model;
    }
}
