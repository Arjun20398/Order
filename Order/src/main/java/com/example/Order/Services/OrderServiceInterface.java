package com.example.Order.Services;

import com.example.Order.Model.OrderDTO;

import java.util.List;

public interface OrderServiceInterface {

    String addOrder(OrderDTO order);

    OrderDTO getOrderById(Integer id);

    List<OrderDTO> merchantOrder(Integer id);
    List<OrderDTO> userOrder(Integer id);
}
