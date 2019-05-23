package com.example.Order.Repository;

import com.example.Order.Entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class UserOrderImpl implements UserOrder{
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Order> findByUserId(Integer id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("orderid").is(id));
        return mongoTemplate.find(query,Order.class);
    }
}
