package com.example.Order.Repository;

import com.example.Order.Entity.Order;

import java.util.List;

public interface MerchantOrder {
    List<Order> findByMerchantId(Integer id);
}

