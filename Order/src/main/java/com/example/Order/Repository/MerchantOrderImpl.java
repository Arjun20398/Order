package com.example.Order.Repository;

import com.example.Order.Entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class MerchantOrderImpl implements MerchantOrder{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Order> findByMerchantId(Integer id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("merchantid").is(id));
        return mongoTemplate.find(query,Order.class);
    }
}

