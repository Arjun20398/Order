package com.example.Order.Controller;


import com.example.Order.Model.OrderDTO;
import com.example.Order.Services.OrderServiceImpl.OrderServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    private OrderServiceImplementation service;

    @PostMapping(value="/addorder",consumes={"application/json"})
    @Transactional
    public String addOrder(@RequestBody OrderDTO order)
    {
        //call update merchant rating send merchant id item number
        //call update product rating send product_id
        return service.addOrder(order);
    }

    @GetMapping("/getorder")
    public OrderDTO getOrderById(@RequestParam Integer id)
    {
        return service.getOrderById(id);
    }

    @GetMapping("/merchantorder")
    public List<OrderDTO> merchantOrder(@RequestParam Integer id)
    {
        return service.merchantOrder(id);
    }
    @GetMapping("/userorder")
    public List<OrderDTO> userOrder(@RequestParam Integer id)
    {
        return service.userOrder(id);
    }
}
